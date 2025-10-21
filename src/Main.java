import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] number1 = {1, 2, 3, 4, 5, 6};
        int[] number2 = {9, 0, 8, 2, 6, 4};
        int[] nr1 = {9,9,9,6};
        int[] nr2 = {8, 9,9,9};
        BigNumbers operations = new BigNumbers();
        System.out.println(Arrays.toString(operations.add(number1,number2)));
        System.out.println(Arrays.toString(operations.add(nr1,nr2)));

        System.out.println(Arrays.toString(operations.subtract(number1,number2)));
        System.out.println(Arrays.toString(operations.subtract(nr1,nr2)));

        System.out.println(Arrays.toString(operations.multiply(nr1,2)));
        System.out.println(Arrays.toString(operations.multiply(number1,2)));

        System.out.println(Arrays.toString(operations.divide(number1,2)));
        System.out.println(Arrays.toString(operations.divide(nr2,9)));



    }
}
