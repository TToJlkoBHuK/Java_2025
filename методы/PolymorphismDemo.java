//OVERLOADING
class ReportPrinter {

    public void print(String text) {
        System.out.println("[Текст]: " + text);
    }

    public void print(int number) {
        System.out.println("[Число]: " + number);
    }

    public void print(String text, int count) {
        System.out.print("[Повтор]: ");
        for (int i = 0; i < count; i++) {
            System.out.print(text + " ");
        }
        System.out.println();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Животное издает неопределенный звук...");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Кот говорит: Мяу!");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Собака говорит: Гав!");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {

        System.out.println("Overloading");
        ReportPrinter printer = new ReportPrinter();

        printer.print("Hello");
        printer.print(100);
        printer.print("Java", 3);

        System.out.println("\nOverriding");

        Animal myAnimal = new Animal();
        Animal myCat = new Cat();
        Animal myDog = new Dog();

        myAnimal.makeSound();
        myCat.makeSound();
        myDog.makeSound();
    }
}