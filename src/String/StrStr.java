//package String;
//
//public class StrStr {
//    public int strStr(String large, String small) {
//        if (large.length() < small.length()) {
//            return -1;
//        }
//        if (small.length() == 0) {
//            return 0;
//        }
//        int largePrime = 101;
//        int prime = 31; // small prime number
//        int seed = 1;
//        int targetHash = small.charAt(0) % largePrime;
//        for (int i = 1; i < small.length(); i++) {
//            seed = moduleHash(seed, 0, prime, largePrime);
//            targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
//        }
//        int hash = 0;
//        for (int i = 0; i < small.length(); i++) {
//            hash = moduleHash(hash, large.charAt(i), prime, largePrime);
//        }
//        if (hash == targetHash && equals(large, 0, small)) {
//            return 0;
//        }
//        for (int i = 1; i <= large.length() - small.length(); i++) {
//            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
//            hash = moduleHash(hash, large.charAt(i + small.length() - 1), prime, largePrime);
//        }
//        if (hash == targetHash && equals(large, i, small)) {
//            return i;
//        }
//        return -1;
//    }
//    public boolean equals(String large, int start, String small) {
//        for (int i = 0; i < small.length(); i++) {
//            if (large.charAt(i + start) != small.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//    public int moduleHash(int hash, ) {
//
//    }
//    public static void main(String[] args) {
//        System.out.println(strStr("abcdefghijklmnopqrstuvwxyzzabcdefghijklmnopqrstu", "qrstuvwxyzzabcdefghijklmnopqrstu")); // expected: 0
//    }
//}
//
//
//
//    public static int strStr(String large, String small) {
//        int patternSize = small.length();
//        // sanity check
//        if (patternSize == 0) {
//            return 0;
//        }
//        int smallHash = hash(small);
//        for (int i = 0; i < large.length() - patternSize + 1; i++) {
//            int largeHash = hash(large.substring(i, patternSize + i));
//            if (smallHash == largeHash) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private static int hash(String small) {
//        int result = 0;
//        for (int i = 0; i < small.length(); i++) {
//            result += small.charAt(i) * Math.pow(31, small.length() - i - 1);
//        }
//        return result;
//    }
//
//    private static int hash(String s) {
//        return s.hashCode();
//    }
