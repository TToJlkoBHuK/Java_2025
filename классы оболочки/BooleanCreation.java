public class BooleanCreation {
    public static void main(String[] args) {
        //Автоупаковка
        Boolean b1 = true;

        //фабрика
        Boolean b2 = Boolean.valueOf(true);
        Boolean b3 = Boolean.valueOf("true");

        //константа
        Boolean b4 = Boolean.TRUE;
        Boolean b5 = Boolean.FALSE;

        //Конструкторы
        Boolean b6 = new Boolean(true);
        Boolean b7 = new Boolean("true");

        System.out.println("Все созданы успешно: " + b1);
    }
}