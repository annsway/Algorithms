package String;

import java.util.ArrayList;
import java.util.List;

public class PrintNewsArticle {
    String[] solution(String text, int width) {
        List<String> list = new ArrayList<>();
        StringBuilder header = new StringBuilder();
        for (int i = 0; i < width + 2; i++) {
            header.append('*');
        }
        list.add(header.toString());
        List<String> buffer = new ArrayList<>();
        int start = 0, end = 0, n = text.length();
        while (end < n) {
            if (text.charAt(end) == '.' || text.charAt(end) == '?'  || text.charAt(end) == '!') {
                String s = text.substring(start, end + 1);
                buffer.add(s);
                end++;
                start = end;
            } else {
                end++;
            }
        }
        // System.out.println(buffer);
        for (String sent : buffer) {
            StringBuilder sb = new StringBuilder();
            sb.append("*  "); // start of a sentence

            String[] words = sent.split(" ");
            int curLen = 2;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (curLen + word.length() <= width) { // case 1: keep appending current word to current line
                    sb.append(word);
                    curLen += word.length();
                    if (curLen < width) { // add a space between words, if not EOL
                        sb.append(" ");
                        curLen++;
                    }
                } else { // case 2: when the current line cannot fit the current word

                    // a. finish current line and add it to the res list
                    for (int k = curLen; k < width; k++) {
                        sb.append(" ");
                    }
                    sb.append("*");
                    list.add(sb.toString());

                    // b. start a new line
                    sb = new StringBuilder();
                    sb.append("*").append(word);

                    curLen = word.length();
                    if (curLen < width) {
                        sb.append(" ");
                        curLen++;
                    }
                }
            }
            // EOS (no words left) - fill any extra spaces to meet the given width
            for (int k = curLen; k < width; k++) {
                sb.append(" ");
            }
            sb.append("*");
            list.add(sb.toString());
        }
        list.add(header.toString());
        // output
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String text = "Hi! This is the article you have to format properly. Could you do that for me, please?";
        PrintNewsArticle sol = new PrintNewsArticle();
        String[] res = sol.solution(text, 16);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
