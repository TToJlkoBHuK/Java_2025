// Ex1 родитель
class Ex1 extends Exception {
    public Ex1(String message) { super(message); }
}

//Ex2 наследник Ex1
class Ex2 extends Ex1 {
    public Ex2(String message) { super(message); }
}

// Ex3 наследник Ex2
class Ex3 extends Ex2 {
    public Ex3(String message) { super(message); }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("--- Демонстрация идентичной обработки ---");
        handleIdentically();

        System.out.println("\n--- Демонстрация иерархии ---");
        handleHierarchy(3);
    }

    //СИТУАЦИЯ 1
    public static void handleIdentically() {
        try {
            if (System.nanoTime() % 2 == 0) {
                throw new ArithmeticException("Ошибка арифметики");
            } else {
                throw new NullPointerException("Ошибка null");
            }
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Поймана стандартная ошибка: " + e.getMessage());
        }
    }

    //СИТУАЦИЯ 2
    public static void handleHierarchy(int type) {
        try {
            if (type == 3) throw new Ex3("Это Ex3");
            if (type == 2) throw new Ex2("Это Ex2");
            if (type == 1) throw new Ex1("Это Ex1");
        }
        catch (Ex3 e) {
            System.out.println("Перехвачен Ex3 (самый младший): " + e.getMessage());
        }
        catch (Ex2 e) {
            System.out.println("Перехвачен Ex2 (средний): " + e.getMessage());
        }
        catch (Ex1 e) {
            System.out.println("Перехвачен Ex1 (самый старший): " + e.getMessage());
        }
    }
}