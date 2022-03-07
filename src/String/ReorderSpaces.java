package String;

import java.util.ArrayList;
import java.util.List;

public class ReorderSpaces {
    public String reorderSpaces(String text) {
        char[] array = text.toCharArray();
        List<String> list = new ArrayList<>();
        int countSpaces = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ') {
                StringBuilder sb = new StringBuilder();
                while (i < array.length && array[i] != ' ') {
                    sb.append(array[i++]);
                }
                list.add(sb.toString());
            }
            if (i < array.length && array[i] == ' ') {
                countSpaces++;
            }
        }
        int countWords = list.size();
        int avgSpaces = countWords == 1 ? 0 : countSpaces / (countWords - 1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
            if (i != list.size() - 1) {
                int cnt = 0;
                while (cnt < avgSpaces) {
                    res.append(" ");
                    cnt++;
                }
            }
        }
        int extraSpaces = 0;
        if (countWords == 1) {
            extraSpaces = countSpaces;
        } else {
            extraSpaces = countSpaces - ((countSpaces / (countWords - 1)) * (countWords - 1));
        }
        while (extraSpaces > 0) {
            res.append(" ");
            extraSpaces--;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ReorderSpaces sol = new ReorderSpaces();
//        System.out.println(sol.reorderSpaces("  this   is  a sentence "));
//        System.out.println(sol.reorderSpaces(" practice   makes   perfect"));
        System.out.println(sol.reorderSpaces("  hello"));

    }
}
