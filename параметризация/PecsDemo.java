import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PecsDemo {

    public static void main(String[] args) {
        // <? extends T>
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Double> doubles = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("Сумма целых: " + sumNumbers(integers));
        System.out.println("Сумма дробных: " + sumNumbers(doubles));


        //<? super T>
        List<Number> numList = new ArrayList<>();
        List<Object> objList = new ArrayList<>();

        addIntegers(numList);
        addIntegers(objList);

        System.out.println("Список Number: " + numList);
        System.out.println("Список Object: " + objList);
    }

    public static double sumNumbers(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
    }
}