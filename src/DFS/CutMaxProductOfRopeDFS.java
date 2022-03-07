package DFS;

public class CutMaxProductOfRopeDFS {
    public int maxProduct(int n) {
        if (n == 1) {
            return 0;
        }
        int maxProduct = 0;
        for (int i = 1; i < n; i++) {
            int curMax = Math.max(n - i, maxProduct(n - i));
            maxProduct = Math.max(maxProduct, i * curMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        CutMaxProductOfRopeDFS sol = new CutMaxProductOfRopeDFS();
        System.out.println(sol.maxProduct(5));
    }

}
