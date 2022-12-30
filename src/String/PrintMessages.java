package String;

import java.util.ArrayList;
import java.util.List;

public class PrintMessages {
    static String[] solution(String[][] messages, int width, int userWidth) {
        List<String> list = new ArrayList<>();
        StringBuilder header = new StringBuilder();
        header.append('+');
        for (int i = 0; i < width; i++) {
            header.append('*');
        }
        header.append('+');
        list.add(header.toString());

        for (String[] message : messages) {
            String user = message[0];
            String msg = message[1];
            String[] words = msg.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                if (i == 0) {
                    sb.append(words[i]);
                } else if (sb.length() + 1 + words[i].length() <= userWidth) {
                    sb.append(" ").append(words[i]);
                } else {
                    // add previous sb to res
                    print(width, sb, user, list);
                    // start a new sb
                    sb = new StringBuilder();
                    sb.append(words[i]);
                }
            }
            print(width, sb, user, list);
        }

        list.add(header.toString());
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static void print(int width, StringBuilder sb, String user, List<String> list) {
        int spaces = width - sb.length();
        if (user.equals("1")) {
            while (spaces > 0) {
                sb.append(" ");
                spaces--;
            }
        } else {
            while (spaces > 0) {
                sb.insert(0, " ");
                spaces--;
            }
        }
        sb.insert(0, "|");
        sb.append("|");
        list.add(sb.toString());
    }

    public static void main(String[] args) {
        String[][] messages = {{"1", "Hello how r u"},
                                {"2", "good ty"},
                                {"2", "u"},
                                {"1", "me too bro"}
        };
        String[] res = PrintMessages.solution(messages, 15, 5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
