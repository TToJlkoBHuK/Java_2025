import java.util.ArrayList;
import java.util.List;

public class InstanceofDemo {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Java");
        strings.add("Core");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);

        System.out.println("--- Проверка строк ---");
        inspectObject(strings);

        System.out.println("\n--- Проверка чисел ---");
        inspectObject(numbers);

        System.out.println("\n--- Проверка строки (не списка) ---");
        inspectObject("Просто строка");
    }

    public static void inspectObject(Object obj) {

        if (obj instanceof List<?>) {
            System.out.println("✅ Это список!");

            List<?> list = (List<?>) obj;

            System.out.println("Размер списка: " + list.size());

            if (!list.isEmpty()) {
                Object firstElement = list.get(0);
                System.out.println("Первый элемент: " + firstElement);
                System.out.println("Класс элемента: " + firstElement.getClass().getSimpleName());
            }
        } else {
            System.out.println("❌ Это не список, это: " + obj.getClass().getSimpleName());
        }
    }
}