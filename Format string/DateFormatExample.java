import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        Date now = new Date();

        // %1$ - означает, что мы берем 1-й аргумент (переменную now) для всех вставок
        System.out.printf("Сегодня: %1$tA, %1$tB %1$tY года.%n", now);
        System.out.printf("Точное время: %1$tH:%1$tM%n", now);
    }
}