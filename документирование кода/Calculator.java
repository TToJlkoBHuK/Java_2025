/**
 * Класс Calculator предоставляет базовые математические операции.
 * * <p>Этот класс предназначен для демонстрации использования Javadoc.
 * * @author alexey
 * @version 1.0
 * @since 2025-11-20
 */
public class Calculator {

    /**
     * Выполняет сложение двух целых чисел.
     * <p>
     * Если оба числа слишком велики, возможно целочисленное переполнение.
     *
     * @param num1 Первое целое число.
     * @param num2 Второе целое число, которое нужно прибавить.
     * @return Сумма num1 и num2.
     * @see #subtract(int, int)
     */
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * Выполняет вычитание второго числа из первого.
     * * @param a Уменьшаемое.
     * @param b Вычитаемое.
     * @return Разность a и b.
     */
    public int subtract(int a, int b) {
        return a - b;
    }
}