package merge_k_lists;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(ListNode node : lists) {
            while(node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        Integer item;
        ListNode result = null;
        ListNode head = null;
        while ((item = queue.poll()) != null) {
            if(result == null) {
                result = new ListNode(item);
                head = result;
            } else {
                result.next = new ListNode(item);
                result = result.next;
            }
        }
        return head;
    }
}
