package Math;

public class BrokenCalculator {
    public int brokenCalc(int startValue, int target) {
        if (startValue >= target) {
            return startValue - target;
        }
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }
        return 1 + brokenCalc(startValue, target + 1);
    }

    public static void main(String[] args) {
        BrokenCalculator sol = new BrokenCalculator();
        System.out.println(sol.brokenCalc(5, 8));
    }
}
