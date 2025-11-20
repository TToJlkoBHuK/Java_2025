import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {

        StringJoiner joiner1 = new StringJoiner(", ");

        joiner1.add("Яблоко");
        joiner1.add("Груша");
        joiner1.add("Апельсин");

        System.out.println("Список фруктов: " + joiner1.toString());
        StringJoiner joiner2 = new StringJoiner(" -> ", "[ ", " ]");

        joiner2.add("Москва");
        joiner2.add("Санкт-Петербург");
        joiner2.add("Казань");

        System.out.println("Маршрут: " + joiner2.toString());
    }
}