import java.util.ArrayList;

public class TypeInference {
    public static void main(String[] args) {
        var name = "Alexey";
        var age = 10;

        var list = new ArrayList<String>();
        System.out.println("Тип переменной name: " + name.getClass().getSimpleName());
    }
}