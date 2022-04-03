package Heap;

import java.util.Arrays;
import java.util.Comparator;

public class ImpHeap {
    private int[] array;
    private int size; // heap的size
    private Comparator<Integer> comparator;


    public ImpHeap(int[] array, Comparator<Integer> comparator) {
        if (array == null || array.length == 0) { // array.length 是 heap的capacity
            throw new IllegalArgumentException("input array can not be null or empty");
        }
        this.array = array;
        size = array.length;
        this.comparator = comparator;
        heapify();
    }

    private void heapify() { // 最后一个parent元素的index = size / 2 - 1
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public ImpHeap(int cap) {
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
            // if (array[index] < array[parent]) {
            if (comparator.compare(array[parent], array[index]) > 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        // 左孩子一定存在，右孩子不一定存在, 所以smallestCandidate 默认是leftChild
        while (index <= size / 2 - 1) { // 从 last parent index 开始percolateDown
            // Find the smallest node between the children
            int leftChild = index * 2 + 1; // index 就是 parent
            int rightChild = index * 2 + 2;
            int smallestCandidate = leftChild;
            if (rightChild < size && array[leftChild] >= array[rightChild]) { // 我们需要找到两者中最小的node，这样才能保证在将其与 parent swap后，新的parent 是 min，满足minHeap的堆序性
                smallestCandidate = rightChild;
            }

            if (array[index] > array[smallestCandidate]) {
                swap(index, smallestCandidate);
            } else {
                break;
            }
            index = smallestCandidate;
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
        // If heap reaches the last index of an array, then resize
        if (isFull()) {
            resize();
        }
        array[size] = ele;
        size++; // 将size调整为合法状态后，再percolateUp
        percolateUp(size - 1);
    }

    private void resize() {
        int newSize = (int)(size * 1.5);
        array = Arrays.copyOf(array, newSize);
/**        // overflow-conscious code
 获取原来数组容量的长度
 int oldCapacity = elementData.length;

 新增加的容量长度为原来容量的1.5倍
 int newCapacity = oldCapacity + (oldCapacity >> 1);

 新容量比老容量小，那么新的容量就是老的容量
 if (newCapacity - minCapacity < 0)
 newCapacity = minCapacity;

 新创建的容量超过数组的最大值。抛出异常
 if (newCapacity - MAX_ARRAY_SIZE > 0)
 newCapacity = hugeCapacity(minCapacity);
 // minCapacity is usually close to size, so this is a win:

 调用复制方法，在原来元素上增加容量，这就是传说中的可变集合。用新长度复制原数组。
 elementData = Arrays.copyOf(elementData, newCapacity);
 */
    }

    public int update(int index, int ele) {
        // sanity check
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Invalid Index Range");
        }
        int result = array[index];
        array[index] = ele;
        if (array[index] < result) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;  // update() needs to return the original value
    }

    private void swap(int l, int r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}

