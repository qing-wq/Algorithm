package LeetCode;

public class 环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }

        Boolean isCycle = false;
        ListNode sloPtr = head;
        ListNode fasPtr = head;
        while (fasPtr.next != null && fasPtr.next.next != null) {
            sloPtr = sloPtr.next;
            fasPtr = fasPtr.next.next;
            if (sloPtr == fasPtr) {
                isCycle = true;
                break;
            }
        }

        if (isCycle) {
            sloPtr = head;
            while (sloPtr != fasPtr) {
                sloPtr = sloPtr.next;
                fasPtr = fasPtr.next;
            }
            return sloPtr;
        }
        return null;
    }
}