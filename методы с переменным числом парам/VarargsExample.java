import java.util.Arrays;

public class VarargsExample {

    //var 1
    public void process(int... numbers) {
        System.out.print("[INT Varargs]: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    //var 2
    public void process(String... words) {
        System.out.println("[STRING Varargs]: " + Arrays.toString(words));
    }

    //var 3
    public void process(boolean printSum, int... numbers) {
        int sum = 0;
        System.out.print("[BOOLEAN + INT Varargs]: ");
        for (int n : numbers) {
            sum += n;
        }
        if (printSum) {
            System.out.println("Сумма = " + sum);
        } else {
            System.out.println("Количество = " + numbers.length);
        }
    }

    //var 4
    public void process(String singleWord) {
        System.out.println("[SINGLE String]: " + singleWord.toUpperCase());
    }

    public static void main(String[] args) {
        VarargsExample ex = new VarargsExample();

        System.out.println("--- Тест 1: Разные типы ---");
        ex.process(10, 20, 30);
        ex.process("One", "Two");

        System.out.println("\n--- Тест 2: Дополнительный аргумент ---");
        ex.process(true, 5, 5, 5);

        System.out.println("\n--- Тест 3: Приоритет (Фиксированный vs Varargs) ---");
        ex.process("Hello");

        ex.process(new String[]{"Hello"});
    }
}