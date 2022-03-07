package String;

public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here
        char[] array = input.toCharArray();
        int slow = 0; // [0, slow): result
        int fast = 0; // [slow, fast): explored; [fast, n - 1]: unexplored
        while (fast < array.length) {
            // remove leading spaces
            if (slow == 0 && array[fast] == ' ') {
                fast++;
            } else if (slow > 0 && array[slow - 1] == ' ' && array[fast] == ' ') { // remove duplicate spaces
                fast++;
            } else {
                array[slow++] = array[fast++];
            }
        }
        if (slow > 0 && array[slow - 1] == ' ') {
            slow--;
        }
        return new String(array, 0, slow);
    }

    public static void main(String[] args) {
        RemoveSpaces sol = new RemoveSpaces();
//        System.out.println(sol.removeSpaces("   I     love MTV "));
//        System.out.println(sol.removeSpaces("ILOVEYAHOO"));
        System.out.println(sol.removeSpaces("    a  "));

    }
}
