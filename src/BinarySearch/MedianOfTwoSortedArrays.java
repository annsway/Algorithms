package BinarySearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // A is shorter one; B is longer one
        int lenA = A.length, lenB = B.length;
        if (lenA > lenB) {
            return findMedianSortedArrays(B, A);
        }
        if (lenA == 0) {
            return ((double)B[(lenB - 1) / 2] + (double)B[lenB / 2]) / 2;
        }
        int len = lenA + lenB; // total length
        int A_startK = 0, A_endK = lenA;
        int cutA, cutB;
        // Binary Search on the shorter array
        while (A_startK <= A_endK) {
            cutA = (A_endK + A_startK) / 2; // cutA is the middle point of A
            cutB = (len + 1) / 2 - cutA;
            // L1, R1 => left1, right1; L2, R2 => left2, right2
            double L1 = (cutA == 0) ? Integer.MIN_VALUE : A[cutA - 1];
            double L2 = (cutB == 0) ? Integer.MIN_VALUE : B[cutB - 1];
            double R1 = (cutA == lenA) ? Integer.MAX_VALUE : A[cutA];
            double R2 = (cutB == lenB) ? Integer.MAX_VALUE : B[cutB];
            // We must guarantee that: L1 <= R2 and L2 <= R1
            if (L1 > R2) {
                A_endK = cutA - 1;
            } else if (L2 > R1) {
                A_startK = cutA + 1;
            } else {
                // calculate median
                if (len % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                } else {
                    return Math.max(L1, L2);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        int[] nums1 = {2, 4, 6, 7, 10};
        int[] nums2 = {1, 3, 5, 8, 9, 11, 12, 13, 14};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}
