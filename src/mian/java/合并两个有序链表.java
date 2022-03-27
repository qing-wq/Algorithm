package mian.java;

 class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }


//class 合并两个有序链表 {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1 == null) return l2;
//        if(l2 == null) return l1;
//        ListNode resListNode = new ListNode(0);
//        // resListNode赋给p?
//        ListNode p = resListNode;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                p.next = l1;
//                l1 = l1.next;
//            } else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//            System.out.println(p);
//        }
//        if (l1 != null) {
//            p.next = l1;
//        }
//        if (l2 != null) {
//            p.next = l2;
//        }
//        return resListNode.next;    // ????????????
//    }
//}


class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}