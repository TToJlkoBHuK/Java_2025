public class BufferBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("Начало: " + sb);

        // 1. append(String str)
        // Добавляет строку (или другой тип данных) в конец текущей последовательности.
        sb.append(" World");
        System.out.println("1. append: " + sb);

        // 2. insert(int offset, String str)
        // Вставляет строку в указанную позицию (индекс).
        sb.insert(6, "Java ");
        System.out.println("2. insert: " + sb);

        // 3. delete(int start, int end)
        // Удаляет символы в диапазоне от start (включительно) до end (не включительно).
        sb.delete(0, 6);
        System.out.println("3. delete: " + sb);

        // 4. replace(int start, int end, String str)
        // Заменяет символы в указанном диапазоне на новую строку.
        sb.replace(0, 4, "Super");
        System.out.println("4. replace: " + sb);

        // 5. reverse()
        // Переворачивает последовательность символов задом наперед.
        sb.reverse();
        System.out.println("5. reverse: " + sb);
        sb.reverse();

        // 6. setCharAt(int index, char ch)
        // Изменяет один конкретный символ по указанному индексу.
        sb.setCharAt(0, 'D');
        System.out.println("6. setCharAt: " + sb);

        // 7. deleteCharAt(int index)
        // Удаляет один символ по указанному индексу.
        sb.deleteCharAt(5);
        System.out.println("7. deleteCharAt: " + sb);

        // 8. capacity()
        // Возвращает текущую емкость буфера (количество памяти, выделенной под символы).
        int cap = sb.capacity();
        System.out.println("8. capacity: " + cap);

        // 9. setLength(int newLength)
        // Устанавливает новую длину последовательности.
        sb.setLength(5);
        System.out.println("9. setLength: " + sb);

        // 10. substring(int start, int end)
        // Возвращает новую строку (String), которая является подстрокой текущей последовательности.
        String sub = sb.substring(1, 4);
        System.out.println("10. substring (результат): " + sub);
        System.out.println("    Сам объект остался прежним: " + sb);
    }
}