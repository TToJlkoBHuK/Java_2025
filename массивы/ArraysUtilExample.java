import java.util.Arrays;

public class ArraysUtilExample {
    public static void main(String[] args) {
        int[] numbers = {5, 1, 9, 3, 7};
        int[] numbersCopy = {5, 1, 9, 3, 7};
        int[] otherNumbers = {5, 1, 9, 3, 8};

        //toString(...)
        System.out.println("1. toString: " + Arrays.toString(numbers));

        //equals(...)
        boolean areEqual = Arrays.equals(numbers, numbersCopy);
        System.out.println("2. equals (оригинал и копия): " + areEqual); // true

        //compare(...)
        int comparison = Arrays.compare(numbers, otherNumbers);
        System.out.println("3. compare: " + comparison);

        //sort(...)
        Arrays.sort(numbers);
        System.out.println("4. После sort: " + Arrays.toString(numbers)); // [1, 3, 5, 7, 9]

        //binarySearch(...)
        int indexFound = Arrays.binarySearch(numbers, 7);
        System.out.println("5. binarySearch (число 7): индекс " + indexFound);

        int indexNotFound = Arrays.binarySearch(numbers, 2);
        System.out.println("   binarySearch (число 2): " + indexNotFound);
    }
}