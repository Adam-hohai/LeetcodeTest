package hhuc.cenhelm;

/**
 * 19 删除链表倒数第n个数 中等题
 * 神奇思路：快慢指针，快指针领先慢指针n步，快指针到头时慢指针的位置就是要删除结点的前一位。所以只要遍历一遍就行了
 * 这里还要注意的是，leetcode例子里的链表都是没有通常意义的头结点，他的链表的第一个结点直接就是第一个数，我们建的链表需要加val=0的头结点
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        //ListNode pre_slow = head;
        for (int i = 0; i < n; i++){
            fast = fast.next;
        }
        if(fast == null) return head.next;//防止要删除结点就是第一个
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //while (pre_slow.next != slow) pre_slow = pre_slow.next;
        //pre_slow.next = slow.next;

        slow.next = slow.next.next;
        return head;
    }
}