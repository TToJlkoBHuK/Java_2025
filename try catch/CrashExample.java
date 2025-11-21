public class CrashExample {
    public static void main(String[] args) {
        System.out.println("1. Запуск программы...");

        try {
            int a = 10;
            int b = 0;
            int result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("   -> ОШИБКА ПЕРЕХВАЧЕНА: Нельзя делить на ноль!");
        }

        System.out.println("2. Программа продолжает выполнение после первого блока try-catch...");

        String text = null;

        int length = text.length();

        System.out.println("3. Если вы видите это, значит программа не упала (но она упадет выше).");
    }
}