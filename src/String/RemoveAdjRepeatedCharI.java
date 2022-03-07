package String;

public class RemoveAdjRepeatedCharI {
    public static String deDup(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        int slow = 0; // [0, slow): result
        int fast = 1; // [slow, fast): explored, [fast, input.length()): unexplored
        while (fast < array.length) {
            if (array[fast] == array[slow]) {
                fast++;
            } else {
                slow++;
                array[slow] = array[fast++];
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        System.out.println(deDup("abccde"));
    }

}
