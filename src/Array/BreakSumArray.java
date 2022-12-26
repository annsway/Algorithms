package Array;

import java.util.ArrayList;
import java.util.List;

public class BreakSumArray {
    public static void main(String[] args) {
        BreakSumArray sol = new BreakSumArray();
        System.out.println(sol.solution("1111122222", 3)); // 132
        System.out.println(sol.solution("", 3)); // 0
    }

    String solution(String number, int k) {
        if (number.length() <= k) {
            return number;
        }
        String res = helper(number, k);
        return solution(res, k);
    }

    String helper(String number, int k) {
        int start = 0, end = 0, n = number.length();
        List<String> list = new ArrayList<>();
        while (end < n) {
            while (end - start + 1 > k) {
                start = end;
            }
            if (end == n - 1 || end - start + 1 == k) {
                list.add(number.substring(start, end + 1));
            }
            end++;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            int res = 0;
            int num = Integer.parseInt(s);
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            sb.append(res);
        }
        return sb.toString();
    }
}
