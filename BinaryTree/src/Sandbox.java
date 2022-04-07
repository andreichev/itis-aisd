public class Sandbox {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree<>();
        tree.insert(10);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(20);
        tree.insert(40);

        for(Integer value: tree) {
            System.out.println(value);
        }
    }
}
