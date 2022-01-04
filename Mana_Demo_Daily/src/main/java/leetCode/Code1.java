package leetCode;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * @ClassName Code1
 * @Description TODO
 * @Author RgMana
 * @Date 2021/12/30 16:32
 * @Version 1.0
 **/
public class Code1 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <p>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <p>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     *
     * @param args
     */
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));

        ListNode listNode = addTwoNumbers(listNode1, listNode2);

        StringBuilder sb = new StringBuilder();
        displayListNode(listNode, sb);
        System.out.println(sb);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        displayListNode(l1, sb1);
        displayListNode(l2, sb2);

        //sb1
        //sb2

        Double count = Double.valueOf(sb1.toString()) + Double.valueOf(sb2.toString());

        System.out.println("ss:" + count);

        String s = count.toString();
        s = s.substring(0, s.indexOf("."));

        char[] chars = s.toCharArray();
        //807
        //7 0 8

        new ListNode(8);

        ListNode listNode = null;
        for (int i = 0; i < chars.length; i++) {
            listNode = setListNode(chars[i], listNode);
        }

        return listNode;
    }

    public static ListNode setListNode(char value, ListNode node) {
        System.out.println("Scarlet:" + value);
        ListNode listNode;
        if (node == null) {
            listNode = new ListNode(value - '0');
        } else {
            listNode = new ListNode(value - '0', node);
        }
        return listNode;
    }

    public static void displayListNode(ListNode listNode, StringBuilder sb) {
        if (listNode.next != null) {
            displayListNode(listNode.next, sb);
        }
        sb.append(listNode.getVal());
    }


    public static class ListNode {
        @Getter
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
}
