package com.zsg.onhundred;

/**
 * @BelongsProject: LeetCode
 * @BelongsPackage: com.zsg.onhundred
 * @Author: 张世罡
 * @CreateTime: 2022-07-23 23:48
 * @Description: 002 add two numbers
 */
public class exam_002_addtwonum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(6);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println("ListNode节点值：" + result.val);
            result = result.next;
        }
    }

    /**
     * input:(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * output: 7 -> 0 -> 8
     * <p>
     * time:O(n)
     * space:O(n)
     * @param l1 节点1
     * @param l2 节点2
     * @return 返回执行结果
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode curr = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
        }
        if (sum == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
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
