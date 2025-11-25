import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Главный класс приложения.
 * Отвечает за взаимодействие с пользователем (CLI) и оркестрацию процесса.
 */
public class HuffmanArchiver {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage:");
            System.out.println("  encode <input_file> <output_file>");
            System.out.println("  decode <input_file> <output_file>");
            return;
        }

        String command = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        try {
            HuffmanCodec codec = new HuffmanCodec();
            long startTime = System.currentTimeMillis();

            if ("encode".equalsIgnoreCase(command)) {
                System.out.println("Encoding " + inputFile + "...");
                codec.compress(inputFile, outputFile);
                printStats(inputFile, outputFile, startTime);
            } else if ("decode".equalsIgnoreCase(command)) {
                System.out.println("Decoding " + inputFile + "...");
                codec.decompress(inputFile, outputFile);
                System.out.println("Done in " + (System.currentTimeMillis() - startTime) + "ms.");
            } else {
                System.out.println("Unknown command: " + command);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printStats(String in, String out, long startTime) {
        File inFile = new File(in);
        File outFile = new File(out);
        long inSize = inFile.length();
        long outSize = outFile.length();
        System.out.println("Original size: " + inSize + " bytes");
        System.out.println("Compressed size: " + outSize + " bytes");
        System.out.printf("Compression ratio: %.2f%%\n", (100.0 - ((double) outSize / inSize * 100)));
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}

/**
 * Класс, реализующий логику сжатия и распаковки.
 */
class HuffmanCodec {

    // --- КОДИРОВАНИЕ ---
    public void compress(String srcPath, String destPath) throws IOException {
        byte[] inputData = Files.readAllBytes(Paths.get(srcPath));

        // 1. Подсчет частот
        Map<Byte, Integer> frequencyMap = new HashMap<>();
        for (byte b : inputData) {
            frequencyMap.put(b, frequencyMap.getOrDefault(b, 0) + 1);
        }

        // 2. Построение дерева и таблицы кодов
        HuffmanTree tree = new HuffmanTree(frequencyMap);
        Map<Byte, String> codeTable = tree.buildCodeTable();

        // 3. Запись в файл
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(destPath));
             BitOutputStream bitOut = new BitOutputStream(dos)) {

            // Header: Размер словаря
            dos.writeInt(frequencyMap.size());
            // Header: Словарь (байт -> частота)
            for (Map.Entry<Byte, Integer> entry : frequencyMap.entrySet()) {
                dos.writeByte(entry.getKey());
                dos.writeInt(entry.getValue());
            }
            // Header: Длина исходных данных (для отсечения лишних битов в конце)
            dos.writeLong(inputData.length);

            // Body: Данные
            for (byte b : inputData) {
                String bits = codeTable.get(b);
                for (char bit : bits.toCharArray()) {
                    bitOut.writeBit(bit == '1' ? 1 : 0);
                }
            }
        } // bitOut.close() автоматически вызовет flush и закроет поток
    }

    // --- ДЕКОДИРОВАНИЕ ---
    public void decompress(String srcPath, String destPath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(srcPath));
             BitInputStream bitIn = new BitInputStream(dis);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            // 1. Чтение заголовка
            int tableSize = dis.readInt();
            Map<Byte, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < tableSize; i++) {
                byte b = dis.readByte();
                int freq = dis.readInt();
                frequencyMap.put(b, freq);
            }
            long dataLength = dis.readLong();

            // 2. Восстановление дерева
            HuffmanTree tree = new HuffmanTree(frequencyMap);
            Node root = tree.getRoot();

            // 3. Декодирование потока битов
            Node current = root;
            long bytesWritten = 0;

            while (bytesWritten < dataLength) {
                int bit = bitIn.readBit();
                if (bit == -1) break;

                // Идем по дереву
                if (bit == 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }

                // Если лист - записываем байт и возвращаемся в корень
                if (current.isLeaf()) {
                    fos.write(current.byteValue);
                    bytesWritten++;
                    current = root;
                }
            }
        }
    }
}

/**
 * Структура данных Дерева Хаффмана.
 */
class HuffmanTree {
    private final Node root;

    public HuffmanTree(Map<Byte, Integer> frequencies) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Byte, Integer> entry : frequencies.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Если файл состоит из 1 уникального символа, создаем фиктивный корень
        if (pq.size() == 1) {
            Node onlyNode = pq.poll();
            // Искусственно создаем родителя, чтобы путь был "0"
            pq.add(new Node(null, onlyNode.frequency, onlyNode, null));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(null, left.frequency + right.frequency, left, right);
            pq.add(parent);
        }
        this.root = pq.poll();
    }

    public Node getRoot() {
        return root;
    }

    public Map<Byte, String> buildCodeTable() {
        Map<Byte, String> map = new HashMap<>();
        if (root != null) {
            buildTableRecursive(root, "", map);
        }
        return map;
    }

    private void buildTableRecursive(Node node, String code, Map<Byte, String> map) {
        if (node.isLeaf()) {
            map.put(node.byteValue, code);
        } else {
            if (node.left != null) buildTableRecursive(node.left, code + "0", map);
            if (node.right != null) buildTableRecursive(node.right, code + "1", map);
        }
    }
}

/**
 * Узел дерева. Реализует Comparable для очереди с приоритетом.
 */
class Node implements Comparable<Node> {
    final Byte byteValue; // null for internal nodes
    final int frequency;
    final Node left;
    final Node right;

    // Конструктор для листа
    public Node(Byte byteValue, int frequency) {
        this(byteValue, frequency, null, null);
    }

    // Конструктор для внутреннего узла
    public Node(Byte byteValue, int frequency, Node left, Node right) {
        this.byteValue = byteValue;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.frequency, o.frequency);
    }
}

/**
 * Утилита для побитовой записи в поток.
 */
class BitOutputStream implements AutoCloseable {
    private final OutputStream out;
    private int currentByte = 0;
    private int numBitsFilled = 0;

    public BitOutputStream(OutputStream out) {
        this.out = out;
    }

    public void writeBit(int bit) throws IOException {
        if (bit != 0 && bit != 1) throw new IllegalArgumentException("Bit must be 0 or 1");

        currentByte = (currentByte << 1) | bit;
        numBitsFilled++;

        if (numBitsFilled == 8) {
            out.write(currentByte);
            currentByte = 0;
            numBitsFilled = 0;
        }
    }

    @Override
    public void close() throws IOException {
        // Дописываем padding (нули), если байт не заполнен
        while (numBitsFilled != 0 && numBitsFilled < 8) {
            writeBit(0);
        }
        out.close();
    }
}

/**
 * Утилита для побитового чтения из потока.
 */
class BitInputStream implements AutoCloseable {
    private final InputStream in;
    private int currentByte;
    private int numBitsRemaining = 0;

    public BitInputStream(InputStream in) {
        this.in = in;
    }

    public int readBit() throws IOException {
        if (numBitsRemaining == 0) {
            currentByte = in.read();
            if (currentByte == -1) return -1;
            numBitsRemaining = 8;
        }

        numBitsRemaining--;
        return (currentByte >> numBitsRemaining) & 1;
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}