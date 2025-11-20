public class UnboxingNPE {
    public static void main(String[] args) {
        Integer wrapper = null;

        try {
            // Java пытается превратить wrapper в int.
            // Это эквивалентно вызову: wrapper.intValue() -> null.intValue()
            int primitive = wrapper;
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: попытка автораспаковки null");
        }

        try {
            int sum = wrapper + 10;
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение при арифметике");
        }
    }
}