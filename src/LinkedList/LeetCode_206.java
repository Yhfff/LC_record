package LinkedList;
//反转链表
public class LeetCode_206
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 双指针
    public static ListNode reverseList(ListNode head)
    {
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode temp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    //递归
    public static ListNode reverseList_2(ListNode head)
    {
        return reverse(head, null);
    }

    public static ListNode reverse(ListNode cur,ListNode pre)
    {
        if(cur==null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(temp, cur);
    }
}
