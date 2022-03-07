package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityNumberII {
    public List<Integer> majority(int[] array) {
        List<Integer> res = new ArrayList<>();
        Integer limit = array.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : array) {
            Integer oldCnt = map.get(num);
            if (oldCnt == null) {
                map.put(num, 1);
            } else {
                map.put(num, oldCnt + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > limit) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MajorityNumberII sol = new MajorityNumberII();
        System.out.println(sol.majority(new int[]{1, 2, 3, 1, 1}));
    }
}
