public class JumpOperators {
    public static void main(String[] args) {
        System.out.println("Начало цикла:");

        for (int i = 0; i < 10; i++) {

            //continue
            if (i == 3) {
                System.out.println("-> Пропуск числа 3 (continue)");
                continue;
            }

            //break
            if (i == 6) {
                System.out.println("-> Выход из цикла на числе 6 (break)");
                break;
            }

            System.out.println("Значение i: " + i);
        }

        System.out.println("Цикл завершен.");
    }
}