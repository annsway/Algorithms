package String;

import java.util.Arrays;

public class ReverseWordsInString {
    public String reverseWords(String input) {
        // trim the input string
        char[] array = trim(input.toCharArray());
        // reverse the whole string
        reverse(array, 0, array.length - 1);
        // reverse each word
        int left = 0;
        int right = 0;
        while (right < array.length) {
            if (array[right] == ' ') {
                reverse(array, left, right - 1);
                right++;
                left = right;
            } else if (right == array.length - 1) {
                reverse(array, left, right);
                break;
            } else {
                right++;
            }
        }
        return new String(array);
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    private char[] trim(char[] array) {
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            // trim the spaces in the middle
            while ((fast == 0 && array[fast] == ' ') ||
                    (fast >= 1 && array[fast - 1] == ' ' && array[fast] == ' ')) {
                fast++;
                if (fast >= array.length) {
                    break;
                }
            }
            array[slow++] = array[fast++];
        }
        // trim the end
        if (slow - 1 >= 0 && array[slow - 1] == ' ') {
            slow--;
        }
        return Arrays.copyOfRange(array, 0, slow);
    }

    public static void main(String[] args) {
        String s = "   the sky is  blue  ";
        ReverseWordsInString sol = new ReverseWordsInString();
        System.out.println(sol.reverseWords(s));
    }
}
