import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScannerDemo {
    public static void main(String[] args) {
        File file = new File("notes.txt");

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден!");
            e.printStackTrace();
        }
    }
}