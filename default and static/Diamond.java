interface A {
    default void hello() {
        System.out.println("Привет из интерфейса A");
    }
}

interface B {
    default void hello() {
        System.out.println("Привет из интерфейса B");
    }
}

class C implements A, B {

    // ОШИБКА КОМПИЛЯЦИИ возникла бы здесь, если бы мы не переопределили метод
    
    @Override
    public void hello() {
        //Вариант 1
        System.out.println("Своя логика в классе C");

        //Вариант 2
        A.super.hello();

        //Вариант 3
        B.super.hello();
    }
}

public class Diamond {
    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}