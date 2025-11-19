public class MixedMath {
    public static void main(String[] args) {
        int i = 10;
        double d = 5.5;
        byte b = 2;

        var result1 = i + d;
        System.out.println(result1 + " (тип double)");

        var result2 = b + i;
        System.out.println(result2 + " (тип int)");
    }
}