import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyBinaryTree<T extends Comparable<T>> implements Iterable<T> {
    private static class MyBinaryTreeIterator<T extends Comparable<T>> implements Iterator<T> {
        private List<T> list = new ArrayList<>();
        private int currentIndex = 0;

        public MyBinaryTreeIterator(Node<T> root) {
            getValue(root);
        }

        private void getValue(Node<T> node) {
            if(node == null) {
                return;
            }
            list.add(node.value);
            getValue(node.left);
            getValue(node.right);
        }

        @Override
        public boolean hasNext() {
            return currentIndex < list.size();
        }

        @Override
        public T next() {
            T value = list.get(currentIndex);
            currentIndex++;
            return value;
        }
    }

    static class Node<T extends Comparable<T>> {
        Node left;
        Node right;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
    private Node root;

    void insert(T value) {
        if(root == null) {
            root = new Node<T>(value);
            return;
        }
        insert(value, root);
    }

    private void insert(T value, Node<T> node) {
        if(value.compareTo(node.value) >= 0) {
            if(node.right == null) {
                node.right = new Node<T>(value);
            } else {
                insert(value, node.right);
            }
        } else {
            if(node.left == null) {
                node.left = new Node<T>(value);
            } else {
                insert(value, node.left);
            }
        }
    }

    boolean contains(T value) {
        if(root == null) {
            return false;
        }
        return contains(value, root);
    }

    private boolean contains(T value, Node<T> node) {
        if(node.value.compareTo(value) == 0) {
            return true;
        }
        if(value.compareTo(node.value) > 0) {
            if(node.right != null) {
                return contains(value, node.right);
            }
        } else {
            if(node.left != null) {
                return contains(value, node.left);
            }
        }
        return false;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new MyBinaryTreeIterator<T>(root);
    }
}
