package Array;

public class TrappingRainWater {
    public int trap(int[] height) {
        int length = height.length;
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        int mL = height[0];
        int mR = height[length - 1];
        int ans = 0;
        // initialize
        for (int i = 0; i < length; i++) {
            mL = Math.max(mL, height[i]);
            maxLeft[i] = mL;
        }
        for (int i = length - 1; i >= 0; i--) {
            mR = Math.max(mR, height[i]);
            maxRight[i] = mR;
        }
        for (int i = 0; i < length; i++) {
            int curHeight = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (curHeight > 0) {
                ans += curHeight;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {4, 2, 3};
        TrappingRainWater sol = new TrappingRainWater();
        System.out.println(sol.trap(height)); // 1
    }
}
