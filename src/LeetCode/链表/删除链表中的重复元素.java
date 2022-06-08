package LeetCode.链表;

class 删除链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode p = head;
//        while (p.next != null) {
//            if (p.val == p.next.val) {
//                p.next = p.next.next;
//            } else {
//                p = p.next;
//            }
//        }
//        return head;

        if (head == null || head.next == null) {
            return null;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}