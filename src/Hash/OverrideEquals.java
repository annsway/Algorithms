package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class OverrideEquals {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        l1.equals(l2); // true; used the .equals() method from AbstractList class

        Map<LinkedList<Integer>, Integer> map = new HashMap<>();
        map.put(l1, 10);
        map.get(l2);
        /** get(Object key) 允许你传入一个非已定义的Key类型(这里map里的定义的key是LL)的数据，
         因为就像这里的例子中，l1与l2虽然类型不同，但是因为它们里面存的数据都相同，通过equals()比较，
         在java中l1与l2其实是相同的。但是，因为get的参数类型是Object, 所以在对map进行search操作时，
         必须调用已定义的Key类型中的l1.equals()方法来比较l1与l2, 否则l2.equals()调用的是Object.equals(),
         which is to compare two objects using their references, not values!
         */
        System.out.println(map.get(l2)); // returns 10 -- Java thinks l1.equals(l2) == true
    }
}
