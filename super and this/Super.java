class Parent {
    String text = "Поле родителя";

    Parent(String message) {
        System.out.println("Конструктор Parent: " + message);
    }

    void printMessage() {
        System.out.println("Метод Parent: Привет из родительского класса");
    }
}

class Child extends Parent {
    String text = "Поле потомка";

    Child() {
        //var 1
        super("Вызван из Child");
    }

    void display() {
        //var 2
        System.out.println("text в Child: " + this.text);
        System.out.println("text в Parent: " + super.text);

        //var 3
        super.printMessage();
    }

    @Override
    void printMessage() {
        System.out.println("Метод Child: Привет из дочернего класса");
    }
}

public class Super {
    public static void main(String[] args) {
        Child child = new Child();
        child.display();
    }
}