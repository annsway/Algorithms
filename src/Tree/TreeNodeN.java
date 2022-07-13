package Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeN {
    public int val; // LeetCode
    public int key; // LaiCode
    public List<TreeNodeN> children;

    public TreeNodeN(int val) {
        this.val = val;
        this.key = val;
        this.children = new ArrayList<>();
    }
}
