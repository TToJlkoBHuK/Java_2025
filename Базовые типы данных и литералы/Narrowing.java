public class Narrowing {
    public static void main(String[] args) {
        double myDouble = 9.78;

        int myInt = (int) myDouble;
        System.out.println(myInt);

        int bigInt = 130;
        byte myByte = (byte) bigInt;
        System.out.println(myByte);
    }
}