class Parent {
    // Обычный метод - можно переопределять
    public void standardMethod() {
        System.out.println("Обычный метод родителя");
    }

    // FINAL метод - переопределять нельзя
    public final void secureMethod() {
        System.out.println("Критически важная логика родителя");
    }
}

class Child extends Parent {

    @Override
    public void standardMethod() {
        System.out.println("Измененный метод в наследнике");
    }

    // (Нельзя переопределить final метод из Parent)
    /*
    @Override
    public void secureMethod() {
        System.out.println("Попытка взлома логики");
    }
    */
}