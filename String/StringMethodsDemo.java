public class StringMethodsDemo {
    public static void main(String[] args) {
        String text = "  Java Programming is Awesome!  ";
        String anotherText = "java programming is awesome!";

        System.out.println("Исходная строка: [" + text + "]");

        // 1. length() - Возвращает длину строки (количество символов)
        System.out.println("1. Длина строки: " + text.length());

        // 2. trim() - Удаляет пробелы в начале и в конце строки
        String trimmedText = text.trim();
        System.out.println("2. Строка без пробелов по краям: [" + trimmedText + "]");

        // 3. charAt(int index) - Возвращает символ по указанному индексу (начинается с 0)
        System.out.println("3. Символ под индексом 5: " + trimmedText.charAt(5));

        // 4. substring(int beginIndex, int endIndex) - Вырезает подстроку
        System.out.println("4. Подстрока с 0 по 4: " + trimmedText.substring(0, 4));

        // 5. toUpperCase() - Преобразует все символы в верхний регистр
        System.out.println("5. В верхнем регистре: " + trimmedText.toUpperCase());

        // 6. replace(target, replacement) - Заменяет все вхождения одной последовательности на другую
        System.out.println("6. Замена 'Awesome' на 'Cool': " + trimmedText.replace("Awesome", "Cool"));

        // 7. contains(CharSequence s) - Проверяет, содержит ли строка указанную подстроку
        System.out.println("7. Содержит ли слово 'Java': " + trimmedText.contains("Java"));

        // 8. indexOf(String str) - Возвращает индекс первого вхождения подстроки (или -1, если не найдено)
        System.out.println("8. Индекс начала слова 'Programming': " + trimmedText.indexOf("Programming"));

        // 9. equalsIgnoreCase(String anotherString) - Сравнивает строки без учета регистра
        boolean isEqual = text.trim().equalsIgnoreCase(anotherText);
        System.out.println("9. Равны ли строки (игнорируя регистр): " + isEqual);

        // 10. split(String regex) - Разделяет строку на массив строк по заданному разделителю (пробел)
        String[] words = trimmedText.split(" ");
        System.out.println("10. Разбиение на слова:");
        for (String word : words) {
            System.out.println("   - " + word);
        }
    }
}