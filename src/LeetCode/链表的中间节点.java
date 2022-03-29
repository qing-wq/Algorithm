package LeetCode;

class 链表的中间节点 {
    public ListNode middleNode(ListNode head) {
        ListNode sloPtr = head;
        ListNode fasPtr = head;
        while (fasPtr.next != null && fasPtr!= null) {
            sloPtr = sloPtr.next;
            fasPtr = fasPtr.next.next;
        }
        return sloPtr;
    }
}