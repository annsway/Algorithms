package TwoPointers;

public class StringCompression {
    public int compress(char[] chars) {
        int slow = 0, fast = 0;
        while(fast < chars.length){
            char currentChar = chars[fast];
            int count = 0;
            while(fast < chars.length && chars[fast] == currentChar){
                fast++;
                count++;
            }
            chars[slow++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray())
                    chars[slow++] = c;
        }
        return slow;
    }

    public static void main(String[] args) {
        StringCompression sol = new StringCompression();
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(sol.compress(chars));
    }
}
