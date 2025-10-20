public class BigNumbers {
    public BigNumbers() {
    }

    public int[] sum(int[] nr1, int[] nr2){
        int carry = 0;
        if (nr1.length != nr2.length || nr1[0] == 0 || nr2[0] == 0)
            throw new Error("Length differs");
        int[] result = new int[nr1.length+1];
        for (int i = nr1.length-1; i>=0; i--){
            int sum = nr1[i] + nr2[i];
            result[i] = carry + sum % 10;
            sum /= 10;
            carry = sum;
        }
        if (carry != 0) {
            for (int i = nr1.length; i > 0; i--)
                result[i] = result[i - 1];
            result[0] = carry;
        }
        return result;
    }

    public int[] sub(int[] nr1, int[] nr2){
        int borrowed = 0;
        if (nr1.length != nr2.length || nr1[0] == 0 || nr2[0] == 0)
            throw new Error("Length differs");
        int[] result = new int[nr1.length];
        if (nr2[0] > nr1[0]) {
            for (int i = 0; i < nr1.length; i++) {
                int tmp = nr1[i];
                nr1[i] = nr2[i];
                nr2[i] = tmp;
            }
        }
        for (int i = nr1.length-1; i>0; i--){
            int diff = nr1[i] - nr2[i] - borrowed;
            if (diff < 0) {
                diff += 10;
                borrowed = 1;
            } else {
                borrowed = 0;
            }
            result[i] = diff;
        }
        result[0] = nr1[0] - nr2[0] - borrowed;

        return result;
    }
}
