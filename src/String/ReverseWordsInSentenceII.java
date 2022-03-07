package String;

public class ReverseWordsInSentenceII {
    public String removeSpaces(char[] input) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.length; i++) {
            if (i == 0 && input[i] == ' ') {
                while (input[i] == ' ') {
                    i++;
                }
                start = i;
                end = i;
            }
            if (i - 1 >= 0 && input[i] == ' ' && input[i - 1] == ' ') {
                // not copy
                continue;
            } else if (i == input.length - 1 && input[i] == ' ') {
                break;
            } else {
                input[end++] = input[i]; // copy
            }
        }
        return new String(input, start, end);
    }

    public static void main(String[] args) {
        ReverseWordsInSentenceII sol = new ReverseWordsInSentenceII();
        char[] input = {' ', 'I', ' ', ' ', 'o', ' '};
        System.out.println(sol.removeSpaces(input));
    }
}
