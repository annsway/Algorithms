package Heap;

import java.util.Arrays;

public class ImpMinHeap {
    private int[] array;
    private int size;

    public ImpMinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public ImpMinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity can not be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] > array[index]) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        while (index <= size / 2 - 1) {
            int lChild = index * 2 + 1;
            int rChild = index * 2 + 2;
            int smaller = lChild;
            if (rChild <= size - 1 && array[rChild] < array[smaller]) {
                smaller = rChild;
            }
            if (array[smaller] < array[index]) {
                swap(smaller, index);
                index = smaller;
            } else {
                break;
            }
        }
    }

    public int peek() {
        return isEmpty() ? -1 : array[0];
    }

    public int poll() {
        if (isEmpty()) {
            return -1;
        }
        int res = array[0];
        array[0] = array[size - 1]; // 减少写操作
        size--; // 必须先调整到一个合法的状态，再percolateDown
        percolateDown(0);
        return res;
    }

    public void offer(int ele) {
        if (isFull()) {
            resize();
        }
        array[size++] = ele;
        percolateUp(size - 1);
    }

    private void resize() {
        int newSize = (int)(size * 1.5);
        array = Arrays.copyOf(array, newSize);
    }

    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index Range");
        }
        int oldVal = array[index];
        array[index] = ele;
        if (ele > oldVal) {
            percolateDown(index);
        } else {
            percolateUp(index);
        }
        return oldVal;
    }

    private void swap(int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }

}