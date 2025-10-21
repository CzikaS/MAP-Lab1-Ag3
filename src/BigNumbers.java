public class BigNumbers {
    public BigNumbers() {
    }

    public int[] sum(int[] bigNr1, int[] bigNr2){
        int carry = 0;
        if (bigNr1.length != bigNr2.length || bigNr1[0] == 0 || bigNr2[0] == 0)
            throw new Error("Length differs");
        int[] result = new int[bigNr1.length+1];
        for (int i = bigNr1.length-1; i>=0; i--){
            int sum = bigNr1[i] + bigNr2[i];
            result[i] = carry + sum % 10;
            sum /= 10;
            carry = sum;
        }
        if (carry != 0) {
            for (int i = bigNr1.length; i > 0; i--)
                result[i] = result[i - 1];
            result[0] = carry;
        }
        return result;
    }

    public int[] sub(int[] bigNr1, int[] bigNr2){
        int borrowed = 0;
        if (bigNr1.length != bigNr2.length || bigNr1[0] == 0 || bigNr2[0] == 0)
            throw new Error("Length differs");
        int[] result = new int[bigNr1.length];

        boolean swap = false;
        for (int i = 0; i < bigNr1.length; i++) {
            if (bigNr1[i] > bigNr2[i]) {
                swap = false;
                break;
            } else if (bigNr1[i] < bigNr2[i]) {
                swap = true;
                break;
            }
        }

        if (swap) {
            int[] aux = bigNr1;
            bigNr1 = bigNr2;
            bigNr2 = aux;
        }

        for (int i = bigNr1.length-1; i>0; i--){
            int diff = bigNr1[i] - bigNr2[i] - borrowed;
            if (diff < 0) {
                diff += 10;
                borrowed = 1;
            } else {
                borrowed = 0;
            }
            result[i] = diff;
        }
        result[0] = bigNr1[0] - bigNr2[0] - borrowed;

        int firstNonZero = 0;
        while (firstNonZero < result.length - 1 && result[firstNonZero] == 0) {
            firstNonZero++;
        }
        if (firstNonZero != 0){
            int[] trimmed = new int[result.length - firstNonZero];
            int trimmedIndex = 0;
            for (int index = firstNonZero; index < result.length; index++) {
                trimmed[trimmedIndex] = result[index];
                trimmedIndex++;
            }
            result = trimmed;
        }

        return result;
    }

    public int[] multiply(int[] bigNr, int digit) {
        int n = bigNr.length;
        int[] result = new int[n + 1];
        int carry = 0;

        for (int i = n - 1; i >= 0; i--) {
            int prod = bigNr[i] * digit + carry;
            result[i + 1] = prod % 10;
            carry = prod / 10;
        }

        if (carry == 0){
            int[] trimmed = new int[bigNr.length];
            for (int index = 1; index <= bigNr.length; index++)
                trimmed[index-1] =result[index];
            result = trimmed;
        } else
            result[0] = carry;

        return result;
    }
}
