package Bit;

public class AllUniqueCharactersI {
    public static boolean allUnique(String word) {
        // We need 256 / 32 = 8 int to store the potential positions for ASCII chars in the given String
        int[] seen = new int[8];
        for (int i = 0; i < word.length(); i++) {
            // convert char into ASCII index
            int index = word.charAt(i);
            // find the position of the index in the int[]
            int row = index / 32;
            int col = index % 32;
            if (((seen[row] >> col) & 1) == 1) {
                return false;
            }
            seen[row] |= (1 << col);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allUnique("\\n/b10{-aAM\\n/b90}{-MPO"));
//        System.out.println(allUnique("/"));

    }
}
