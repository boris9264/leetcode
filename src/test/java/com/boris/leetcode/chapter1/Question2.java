package com.boris.leetcode.chapter1;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

/**
 * @Author: boris
 * @Data: Created on 2020/10/23
 * @Description:
 */
public class Question2 {

    /*
        给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
    */

    private ListNode listNode1;

    private ListNode listNode2;

    @Before
    public void init() {
        listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        listNode2 = new ListNode(5, new ListNode(6, new ListNode(9, new ListNode(9))));
    }

    @Test
    public void test() {
        ListNode result = this.addTwoNumbers(listNode1, listNode2);
    }

    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode curNode = new ListNode(0);
        ListNode result = curNode;
        int carry = 0;
        while(true) {
            if (Objects.isNull(listNode1) && Objects.isNull(listNode2) && carry==0) {
                break;
            }
            curNode.next = new ListNode(carry);
            curNode = curNode.next;

            if (!Objects.isNull(listNode1)) {
                curNode.val = curNode.val + listNode1.val;
                listNode1 = listNode1.next;
            }

            if (!Objects.isNull(listNode2)) {
                curNode.val = curNode.val + listNode2.val;
                listNode2 = listNode2.next;
            }

            if (curNode.val >= 10) {
                curNode.val = curNode.val%10;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        return result.next;
    }
}
