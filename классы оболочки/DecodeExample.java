public class DecodeExample {
    public static void main(String[] args) {
        try {
            Integer decimal = Integer.decode("123");
            System.out.println("Десятичное: " + decimal);

            Integer hex1 = Integer.decode("0xFF");
            Integer hex2 = Integer.decode("#FF");
            System.out.println("HEX (255): " + hex1 + " и " + hex2);

            Integer octal = Integer.decode("010");
            System.out.println("Octal (8): " + octal);

            Integer negative = Integer.decode("-0x10");
            System.out.println("Отрицательный HEX (-16): " + negative);

        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа");
        }
    }
}