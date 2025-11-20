public class OperatorsExample {
    public static void main(String[] args) {
        // ( ) [ ]
        int[] arr = {10, 20};
        int groupResult = (5 + 5) * 2;
        System.out.println("Массив: " + arr[0] + ", Группировка: " + groupResult);

        //++, --, ~, !
        boolean isTrue = true;
        System.out.println("Логическое НЕ (!): " + !isTrue);

        int x = 10;
        System.out.println("Побитовое отрицание (~): " + ~x);

        int a = 5;
        int b = ++a;
        System.out.println("Префикс (++a): a=" + a + ", b=" + b);

        int c = 5;
        int d = c++;
        System.out.println("Постфикс (c++): c=" + c + ", d=" + d);

        //*, /, %
        System.out.println("Остаток от деления (10 % 3): " + (10 % 3));

        //+, -
        int sum = 10 + 5;
        String strConcat = "Java " + "Code";
        System.out.println("Числа: " + sum + ", Строка: " + strConcat);

        //>>, >>>, <<
        int val = 8;
        System.out.println("Сдвиг влево (8 << 2): " + (val << 2));
        System.out.println("Сдвиг вправо (8 >> 2): " + (val >> 2));

        //>, <, >=, <=
        System.out.println("Сравнение (10 > 5): " + (10 > 5));

        //==
        System.out.println("Примитивы (5 == 5): " + (5 == 5));
        String s1 = "Hello";
        String s2 = new String("Hello");
        System.out.println("Ссылки String (s1 == s2): " + (s1 == s2));

        //&, ^, |
        System.out.println("Побитовое ИЛИ (5 | 3): " + (5 | 3));
        System.out.println("XOR (5 ^ 3): " + (5 ^ 3));

        //&&, ||
        if (x > 0 && x < 100) {
            System.out.println("Логическое И (&&) сработало");
        }

        //?:
        String status = (x > 5) ? "Big" : "Small";
        System.out.println("Тернарный: " + status);

        //=, +=, -=
        int num = 10;
        num += 5;
        String text = "Hi";
        text += " there";
        System.out.println("Присваивание: " + num + ", Строка: " + text);
    }
}