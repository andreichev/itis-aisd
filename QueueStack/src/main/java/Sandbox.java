import java.util.*;

public class Sandbox {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(8);
        queue.add(8);
        
        Integer item;
        while ((item = queue.poll()) != null) {
            System.out.println(item);
        }

        System.out.println("Queue size: " + queue.size());
    }
}
