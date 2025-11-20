interface Validator {
    boolean validate(String input);

    class Utils {
        public static boolean isEmpty(String s) {
            return s == null || s.trim().isEmpty();
        }

        public void sayHello() {
            System.out.println("Hello from Utils class");
        }
    }
}

public class Main_2 {
    public static void main(String[] args) {
        boolean check = Validator.Utils.isEmpty("");
        System.out.println("Is empty: " + check);

        Validator.Utils utilsObject = new Validator.Utils();
        utilsObject.sayHello();
    }
}