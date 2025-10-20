import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] number1 = {1, 2, 8, 3, 4, 6};
        int[] number2 = {9, 0, 1, 2, 0, 4};
        int[] nr1 = {9,9,9,9};
        int[] nr2 = {9, 9,9,9};
        BigNumbers operations = new BigNumbers();
        System.out.println(Arrays.toString(operations.sum(number1,number2)));
        System.out.println(Arrays.toString(operations.sum(nr1,nr2)));
    }
}
