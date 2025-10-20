public class BigNumbers {
    public BigNumbers() {
    }

    public int[] sum(int[] nr1, int[] nr2){
        int value = 0;
        if (nr1.length != nr2.length || nr1[0] == 0 || nr2[0] == 0)
            throw new Error("Length differs");
        int[] result = new int[nr1.length+1];
        for (int i = nr1.length-1; i>=0; i--){
            int sum = nr1[i] + nr2[i];
            result[i] = value + sum % 10;
            sum /= 10;
            value = sum;
        }
        if (value != 0) {
            for (int i = nr1.length; i > 0; i--)
                result[i] = result[i - 1];
            result[0] = value;
        }
        return result;
    }
}
