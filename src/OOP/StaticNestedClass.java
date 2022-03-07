package OOP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StaticNestedClass {
    public static void main(String args[]) {
        // Create a hash map
        HashMap<String, Integer> hm = new HashMap<>();

        // Put elements to the map
        hm.put("Zara", 100);
        hm.put("Mahnaz", 120);
        hm.put("Ayan", 90);

        // Get a set of the entries
//        Set set = hm.entrySet();

        // Get an iterator
//        Iterator i = set.iterator();

        // Display elements
//        while(i.hasNext()) {
//            Map.Entry me = (Map.Entry)i.next();
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
//        }

        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println("entry key: " + entry.getKey());
            System.out.println("entry value: " + entry.getValue());
        }

    }
}
