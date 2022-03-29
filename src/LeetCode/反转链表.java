package LeetCode;

class 反转链表 {
    public ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode res = new ListNode(0);
//        ListNode p = res;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int k = 0;
//        while (head != null) {
//            map.put(k,head.val);
//            head = head.next;
//            k++;
//        }
//        System.out.println(map.size());
//        while (k >= 0) {
//            p.next = new ListNode(map.get(k));
//            p = p.next;
//            k--;
//        }
//        return res.next;

        ListNode curr = head;
        ListNode proNode = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = proNode;
            proNode = curr;
            curr = next;
        }
    return proNode;
    }
}