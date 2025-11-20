interface SmartInterface {
    //default
    default void defaultMethod() {
        System.out.println("Вызван default метод интерфейса");
    }

    //Статический метод
    static void staticMethod() {
        System.out.println("Вызван static метод интерфейса");
    }
}

class MyClass implements SmartInterface {

}

public class DefaultStatic {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        //DEFAULT
        obj.defaultMethod();

        //STATIC
        SmartInterface.staticMethod();

        // obj.staticMethod();      // Нельзя вызывать статический метод интерфейса через объект
        // MyClass.staticMethod();  // Нельзя вызывать статический метод интерфейса через имя класса-наследника
    }
}