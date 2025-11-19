public class DataTypesExample {
    public static void main(String[] args) {
        byte myByte = 100;
        short myShort = 1000;
        int myInt = 100000;
        long myLong = 100000L;
        float myFloat = 10.5f;
        double myDouble = 20.99;
        char myChar = 'A';
        boolean myBoolean = true;

        String myString = "Hello";
        String nullString = null;
        Integer nullIntWrapper = null;
        Object nullObject = null;

        System.out.println("Примитив int: " + myInt);
        System.out.println("Ссылочный тип (null): " + nullString);
    }
}