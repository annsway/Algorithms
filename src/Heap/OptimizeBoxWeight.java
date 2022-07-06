package Heap;

import java.lang.reflect.Array;
import java.util.*;

public class OptimizeBoxWeight {
    public List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>( (o1, o2) -> Integer.compare(o2, o1));
        long totalWeight = 0;
        for (Integer integer : arr) {
            totalWeight += integer;
            pq.offer(integer);
        }
        List<Integer> boxAElement = new ArrayList<>();
        long currentWeight = 0;
        for (int i = 0; i < arr.size(); i++) {
            int highWeight = pq.poll();
            currentWeight+= highWeight;
            boxAElement.add(highWeight);
            if(currentWeight> totalWeight-currentWeight){
                break;
            }
        }
        Collections.reverse(boxAElement);
        return boxAElement;
    }

    public static void main(String[] args) {
        OptimizeBoxWeight sol = new OptimizeBoxWeight();
        Integer[] arr = {1, 2, 2, 3, 4, 4, 4, 5};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(sol.minimalHeaviestSetA(list));
    }
}
