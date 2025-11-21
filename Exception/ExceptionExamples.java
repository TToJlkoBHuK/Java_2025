public class ExceptionExamples {
    public static void main(String[] args) {

        // 1. ArithmeticException
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
        } catch (ArithmeticException e) {
            System.out.println("Поймано исключение: Деление на ноль! (" + e + ")");
        }

        System.out.println("-------------------");

        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            int wrongElement = numbers[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: Выход за пределы массива! (" + e + ")");
        }

        System.out.println("-------------------");

        // 3. IllegalArgumentException
        try {
            setPercentage(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано исключение: Неверный аргумент! (" + e.getMessage() + ")");
        }

        System.out.println("-------------------");

        // 4. ClassCastException
        try {
            Object stringObj = "Я строка";
            Integer number = (Integer) stringObj;
        } catch (ClassCastException e) {
            System.out.println("Поймано исключение: Ошибка приведения типов! (" + e + ")");
        }

        System.out.println("-------------------");

        // 5. NullPointerException (NPE)
        try {
            String text = null;
            int length = text.length();
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: Обращение к null! (" + e + ")");
        }
    }

    public static void setPercentage(int val) {
        if (val < 0 || val > 100) {
            throw new IllegalArgumentException("Процент должен быть от 0 до 100");
        }
    }
}