package hhuc.cenhelm;

/**
 * 21 两个链表合并 简单题
 * 时间复杂度O（n^2）会超时，所以要降到O（n）
 */

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        //加个头结点，每次都不习惯
//        ListNode head1 = new ListNode(0);
//        ListNode head2 = new ListNode(0);
//        head1.next = l1.next;
//        l1 = head1;
//        head2.next = l2.next;
//        l2 = head2;
//
//        ListNode temp = null;
//        ListNode p = l1;
//        ListNode q = l2.next;
//        while (q != null){
//            while (p != null){
//                if (q.val >= p.val && q.val < p.next.val){
//                    temp = q;
//                    temp.next = p.next;
//                    p.next = temp;
//                }
//                p = p.next;
//            }
//            q = q.next;
//        }
//        return l1.next;
        //O(n)的方法
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            }else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) p.next = l2;//l1先到头，把l2剩下的直接加到l3
        else if (l2 == null) p.next = l1;

        return l3.next;
    }
}
