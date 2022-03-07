package BFS;

import java.util.*;

public class WordLadder {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<>();
//        for (String s : wordList) {
//            set.add(s);
//        }
//        if (!set.contains(endWord)) {
//            return 0; // no such transformation
//        }
//        // BFS
//        Queue<String> q = new ArrayDeque<>();
//        q.offer(beginWord);
//        int n = beginWord.length();
//        int depth = 1;
//        while (!q.isEmpty()) {
//            int size = q.size(); // must record the size, otherwise the depth cannot be calculated
//            depth++;
//            while (size > 0) { // traverse each level
//                System.out.println(q);
//                String cur = q.poll();
//                for (int i = 0; i < n; i++) {
//                    StringBuilder sb = new StringBuilder(cur); // need to be initialized at every iteration
//                    for (char c = 'a'; c < 'z'; c++) { // iterate char from 'a' to 'z' (26 chars)
//                        sb.setCharAt(i, c);
//                        String str = sb.toString();
//                        if (set.contains(str)) {
//                            if (str.equals(cur)) { // skip the same word pulled from the queue
//                                continue;
//                            } else if (str.equals(endWord)) {
//                                return depth;
//                            } else {
//                                set.remove(str);
//                                q.offer(str);
//                            }
//                        }
//                    }
//                }
//                size--;
//            }
//        }
//        return 0;
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String s : wordList) {
            dict.add(s);
        }
        if (!dict.contains(endWord)) {
            return 0;
        }
        // q is to store the words from the dictonary after changing the previous word at previous index
        Queue<String> q = new ArrayDeque<>();
        int len = beginWord.length();
        q.offer(beginWord);
        dict.remove(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (int j = 0; j < len; j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == 'o') {
                            System.out.println("o");;
                        }
                        sb.setCharAt(j, c);
                        String str = sb.toString();
                        if (str.equals(endWord)) {
                            return steps;
                        } else if (str.equals(cur)) {
                            continue;
                        } else if (dict.contains(str)) {
                            q.offer(str);
                            dict.remove(str);
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        WordLadder sol = new WordLadder();

//        String[] words1 = {"git", "hit", "hog", "hot"};
//        List<String> wordList1 = new ArrayList<>(Arrays.asList(words1));
//        System.out.println(sol.ladderLength("git", "hot", wordList1)); // 3

//        String[] words = {"b", "a", "c"};
//        List<String> wordList = new ArrayList<>(Arrays.asList(words));
//        System.out.println(sol.ladderLength("b", "a", wordList)); // 2

        String[] words2 = {"ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain"};
        List<String> wordsList2 = new ArrayList<>(Arrays.asList(words2));
        System.out.println(sol.ladderLength("ymain", "oecij", wordsList2));
    }
}
