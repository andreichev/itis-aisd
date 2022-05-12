package merge_k_lists;

class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode head = null;
        for(;;) {
            int minVal = Integer.MAX_VALUE;
            int minIndex = -1;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minIndex = i;
                }
            }
            if(minIndex == -1) {
                break;
            }
            if(result == null) {
                result = new ListNode(minVal);
                head = result;
            } else {
                result.next = new ListNode(minVal);
                result = result.next;
            }
            lists[minIndex] = lists[minIndex].next;
        }
        return head;
    }
}