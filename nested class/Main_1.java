// Определение интерфейса
interface Printer {
    void print(String message);

    class ConsolePrinter implements Printer {
        @Override
        public void print(String message) {
            System.out.println("Печать в консоль: " + message);
        }

        public void specificMethod() {
            System.out.println("Специфичный метод вложенного класса");
        }
    }
}

public class Main_1 {
    public static void main(String[] args) {

        Printer.ConsolePrinter myPrinter = new Printer.ConsolePrinter();

        myPrinter.print("Hello World!");
        myPrinter.specificMethod();

        Printer p = new Printer.ConsolePrinter();
        p.print("Polymorphic call");
    }
}