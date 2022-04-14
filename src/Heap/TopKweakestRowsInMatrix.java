package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKweakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<Row> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < mat.length; i++) {
            int numSoldiers = getNumSoldiers(mat[i]);
            Row row = new Row(numSoldiers, i);
            if (maxHeap.size() < k) {
                maxHeap.offer(row);
            } else {
                Row topEle = maxHeap.peek();
                if (compare(topEle, row) < 0) {
                    maxHeap.poll();
                    maxHeap.offer(row);
                }
            }
        }
        int index = k - 1;
        while (!maxHeap.isEmpty()) {
            res[index--] = maxHeap.poll().rowNum;
        }
        return res;
    }

    private int getNumSoldiers (int[] row) {
        int res = 0;
        for (int num : row) {
            res += num;
        }
        return res;
    }

    private int compare(Row o1, Row o2) {
        if (o1.numSoldiers > o2.numSoldiers) {
            return -1;
        } else if (o1.numSoldiers == o2.numSoldiers) {
            if (o1.rowNum > o2.rowNum) {
                return -1;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    static class Row implements Comparable<Row> {
        int numSoldiers;
        int rowNum;

        public Row(int numSoldiers, int rowNum) {
            this.numSoldiers = numSoldiers;
            this.rowNum = rowNum;
        }

        @Override
        public int compareTo(Row o2) {
            if (this.numSoldiers > o2.numSoldiers) {
                return -1;
            } else if (this.numSoldiers == o2.numSoldiers) {
                if (this.rowNum > o2.rowNum) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        TopKweakestRowsInMatrix sol = new TopKweakestRowsInMatrix();
        System.out.println(Arrays.toString(sol.kWeakestRows(mat, 3)));
    }
}
