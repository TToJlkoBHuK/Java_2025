public class SwitchTypes {
    enum Color { RED, GREEN }

    public static void main(String[] args) {

        //Примитивы
        int number = 1;
        switch (number) {
            case 1: System.out.println("Это int"); break;
        }

        char letter = 'A';
        switch (letter) {
            case 'A': System.out.println("Это char"); break;
        }

        //Классы-обертки
        Integer wrap = 10;
        switch (wrap) {
            case 10: System.out.println("Это Integer (auto-unboxing)"); break;
        }

        //Строки
        String text = "Java";
        switch (text) {
            case "Java": System.out.println("Это String"); break;
        }

        //Перечисления
        Color color = Color.RED;
        switch (color) {
            case RED: System.out.println("Это Enum"); break;
        }
    }
}