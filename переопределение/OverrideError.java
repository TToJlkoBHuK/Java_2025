class Parent {
    public void calculateData() {
        System.out.println("Parent calculation");
    }
}

class Child extends Parent {

    @Override
    public void calculatData() { //'e'
        System.out.println("Child calculation");
    }
}