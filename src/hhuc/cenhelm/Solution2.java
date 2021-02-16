package hhuc.cenhelm;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数相加
 * 这题并没有完全解决
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * leetcode里单链表的测试用例包括输出都是默认没有头节点的，但实际一般我们写的时候要加头节点（val=0）
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0, num2 = 0;
        int mul = 1;//位数
        int sum = 0;
        String strSum;//结果的字符串
        String[] strArr;//结果的字符串数组
        int[] intArr;//结果的int数组
        // l1 = l1.next;
        // l2 = l2.next;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            num1 = num1 + p1.val * mul;
            mul *= 10;
            p1 = p1.next;
        }
        mul = 1;
        while (p2 != null) {
            num2 = num2 + p2.val * mul;
            mul *= 10;
            p2 = p2.next;
        }
        sum = num1 + num2;
//        strSum = String.valueOf(sum);
//        strSum = new StringBuffer().reverse().toString();
//        strArr = strSum.split("");
//        //srtArr去重
//        List<String> list = new ArrayList<>();
//        for (String str : strArr
//        ) {
//            if (!"".equals(str)) {
//                list.add(str);
//            }
//        }
//        //字符串数组转int数组
//        intArr = new int[list.size()];
//        for (int i = 0; i < intArr.length; i++) {
//            intArr[i] = Integer.parseInt(list.get(i));
//        }

        ListNode l3 = new ListNode(0);
        ListNode p = l3;
//        for (int i = 0; i < intArr.length; i++) {
//            l3.val = intArr[i];
//            l3 = l3.next;
//        }
        //    l3 = l3.next;
        int num = 0;
        if (sum == 0) {
            return l3;
        }
        while (sum != 0) {
            num = sum % 10;
            p.next = new ListNode(num);
            sum = sum / 10;
            p = p.next;
        }
        // for(int i = 0; i < String.valueOf(sum).length(); i++){
        //     num = sum%10;
        //     sum = sum/10;
        //     p.next = new ListNode(num);
        //     p = p.next;
        // }
        return l3.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}