package Tree;

public class ANaryTree {
    public static void main(String[] args) {
        SubtreeWithMaxAverage sol = new SubtreeWithMaxAverage();
        TreeNodeN root = new TreeNodeN(20);

        TreeNodeN node12 = new TreeNodeN(12);
        TreeNodeN node18 = new TreeNodeN(18);

        TreeNodeN node11 = new TreeNodeN(11);
        TreeNodeN node2 = new TreeNodeN(2);
        TreeNodeN node3 = new TreeNodeN(3);

        TreeNodeN node15 = new TreeNodeN(15);
        TreeNodeN node8 = new TreeNodeN(8);

        root.children.add(node12);
        root.children.add(node18);

        node12.children.add(node11);
        node12.children.add(node2);
        node12.children.add(node3);

        node18.children.add(node15);
        node18.children.add(node8);

        System.out.println(root);
    }
}
