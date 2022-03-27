package main.java;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode sloPtr = head;
        ListNode fasPtr = head;
        while (fasPtr.next != null && fasPtr.next.next != null) {
            sloPtr = sloPtr.next;
            fasPtr = fasPtr.next.next;
            if (sloPtr == fasPtr) {
                return true;
            }
        }
        return false;
    }
}