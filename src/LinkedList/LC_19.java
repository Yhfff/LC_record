package LinkedList;
//删除链表的倒数第n个结点
public class LC_19
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //虚拟头节点+快慢指针
    public static ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode dummy = new ListNode(-1,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        //为了使slow指向被删除节点的上一个节点 fast率先移动n+1位
        for(int i=0;i<n+1;i++)
        {
            fast = fast.next;
        }
        while(fast!=null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next; //删除节点
        return dummy.next;
    }
}
