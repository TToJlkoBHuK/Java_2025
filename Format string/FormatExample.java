public class FormatExample {
    public static void main(String[] args) {
        String product = "Ноутбук";
        int quantity = 5;
        double price = 1250.559;
        boolean inStock = true;

        // Пример одной строкой
        System.out.printf("Товар: %s, Количество: %d шт., Цена: %.2f, В наличии: %b%n",
                product, quantity, price, inStock);

        System.out.println("Конец строки.");
    }
}