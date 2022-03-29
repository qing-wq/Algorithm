package LeetCode;

class 链表中倒数第K个节点 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 使用队列
//        Deque<Integer> deque = new ArrayDeque<>();
//        ListNode p = head;
//        int index = 0;
//        int len = 0;
//        while (p != null) {
//            len++;
//            p = p.next;
//        }
////        System.out.println(len);
//        while (head != null) {
////            System.out.println(index);
//            if (index >= len - k) {
//                deque.add(head.val);
//            }
//            head = head.next;
//            index++;
//        }
//        System.out.println(deque.size());
//
//        ListNode res = new ListNode(0);
//        ListNode q = res;
//        while (deque.size() > 0) {
//        q.next = new ListNode(deque.removeFirst());
//        q = q.next;
//        }
//        return res.next;

        // 双指针
        ListNode sloPtr = head,fasPtr = head;
        while (k > 0) {
            fasPtr = fasPtr.next;
            k--;
        }

        while (fasPtr != null) {
            sloPtr = sloPtr.next;
            fasPtr = fasPtr.next;
        }

        ListNode p = sloPtr;
        while (p != null) {
            p = p.next;
        }
        return sloPtr;
    }
}