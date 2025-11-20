import java.util.Objects;

public class Potion {
    private String name;
    private int power;
    private String color;

    public Potion(String name, int power, String color) {
        this.name = name;
        this.power = power;
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        //Рефлексивность
        if (this == o) return true;

        //Проверка на null и соответствие классов
        if (o == null || getClass() != o.getClass()) return false;

        //Приведение типа
        Potion potion = (Potion) o;

        //Сравнение значащих полей
        return power == potion.power &&
                Objects.equals(name, potion.name) &&
                Objects.equals(color, potion.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, color);
    }
}