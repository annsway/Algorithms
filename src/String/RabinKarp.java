package String;

public class RabinKarp {
    public int strStr(String large, String small) {
        // Write your solution here
        if (small.length() == 0) {
            return 0;
        }
        char[] array = small.toCharArray();
        char[] arrayL = large.toCharArray();
        if (arrayL.length < array.length) {
            return -1;
        }
        int token = 0;
        int prime = 101;
        for (int i = 0; i < array.length; i++) {
            token = (token * 26 + (int) array[i]) % prime;
        }
        int hash = 0;
        int num = pow(26, array.length - 1, prime);
        for (int i = 0; i <= arrayL.length - array.length; i++) {
            if (i == 0) {
                for (int j = 0; j < array.length; j++) {
                    hash = (hash * 26 + (int) arrayL[j]) % prime;
                }
                if (hash == token && compare(array, arrayL, 0, array.length)) {
                    return 0;
                }
            } else {
                hash = ((hash - (int) arrayL[i - 1] * num % prime) * 26 + (int) arrayL[i + array.length - 1]) % prime;
                if (hash < 0) {
                    hash += prime;
                }
                if (hash == token && compare(array, arrayL, i, i + array.length)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private boolean compare(char[] array1, char[] array2, int left, int right) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i + left]) {
                return false;
            }
        }
        return true;
    }

    private int pow(int num1, int num2, int prime) {
        if (num2 == 0) {
            return 1;
        }
        int subResult = pow(num1, num2 / 2, prime);
        return num2 % 2 == 1 ? subResult * subResult * num1 % prime : subResult * subResult % prime;
    }
}
