package OOP;

import java.util.ArrayList;
import java.util.List;

public class ListAPI {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        System.out.println(list.get(0)); //IndexOutOfBoundsException
        System.out.println(list.contains(0));
    }
}
