class Bird {
    public void fly(){
        System.out.println("fly");
    }
}

class Duck extends Bird {
    //good
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("not fly!");
    }
}

public class Lisk {
    public void makeBirdFly(Bird bird){
        bird.fly();
    }
}