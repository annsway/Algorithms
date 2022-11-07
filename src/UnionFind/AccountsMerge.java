package UnionFind;

import java.util.*;

public class AccountsMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, Integer> email2acctIdx = new HashMap<>(); // key: email, value: first_index
        Map<Integer, String> acctIdx2name = new HashMap<>(); // key: first_index, value: name

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String emailKey = account.get(j);
                uf.add(i);
                if (!email2acctIdx.containsKey(emailKey)) {
                    email2acctIdx.put(emailKey, i); // put first encountered index for emailKey
                    acctIdx2name.put(i, account.get(0));
                } else {
                    int firstIndex = email2acctIdx.get(emailKey);
                    uf.union(i, firstIndex); // merge current index with firstIndex
                }
            }
        }

        // Build the output
        int numOfSets = uf.getNumOfSets();
        List<List<String>> res = new ArrayList<>();
        System.out.println("numOfSets : " + numOfSets + " res.size(): " + res.size());

        int resIndex = 0;
        Map<Integer, Integer> groupId2resIdx = new HashMap<>();
        for (String email : email2acctIdx.keySet()) {
            int groupId = uf.find(email2acctIdx.get(email)); // find the firstIndex of each group
            // System.out.println(" root index for email(" + email + "): " + groupId);
            if (!groupId2resIdx.containsKey(groupId)) {
                groupId2resIdx.put(groupId, resIndex);
                String acctName = acctIdx2name.get(groupId);
                res.add(new ArrayList<>()); // first, add the name
                List<String> list = res.get(resIndex);
                list.add(acctName);
                list.add(email);
                resIndex++;
            } else {
                int res_i = groupId2resIdx.get(groupId);
                List<String> list = res.get(res_i);
                list.add(email);
            }
        }
        return res;
    }

    static class UnionFind {
        Map<Integer, Integer> map; // <index, parentIndex>
        int numOfSets = 0;

        UnionFind () {
            this.map = new HashMap<>();
        }

        void add(Integer x) {
            if (!map.containsKey(x)) {
                map.put(x, null);
                numOfSets++;
            }
        }

        void union(Integer x, Integer y) {
            Integer rootX = find(x);
            Integer rootY = find(y);
            if (rootX != rootY) {
                map.put(rootX, rootY);
                numOfSets--;
            }
        }

        Integer find(Integer x) {
            Integer root = x;
            while (map.get(root) != null) {
                root = map.get(root);
            }
            // path compression
            while (x != root) {
                Integer old = map.get(x);
                map.put(x, root);
                x = old;
            }
            return root;
        }

        boolean isConnected(Integer x, Integer y) {
            return find(x) == find(y);
        }

        int getNumOfSets() {
            return this.numOfSets;
        }
    }

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("ann", "a1@mail.com", "a2@mail.com");
        List<String> l2 = Arrays.asList("ann","a2@mail.com","a3@mail.com");
        List<String> l3 = Arrays.asList("bob","b1@mail.com");
        List<String> l4 = Arrays.asList("bob","b2@mail.com","b3@mail.com");
        List<List<String>> input = Arrays.asList(l1, l2, l3, l4);
        System.out.println(AccountsMerge.accountsMerge(input));
    }
}
