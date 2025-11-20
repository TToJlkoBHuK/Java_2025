class Animal {
    public void makeSound() {
        System.out.println("Какое-то животное издает звук");
    }
}

class Dog extends Animal {
    // Переопределяем метод родителя    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
}