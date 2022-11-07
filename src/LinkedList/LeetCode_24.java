package LinkedList;
//两两交换链表中的节点
public class LeetCode_24
{
    public static class ListNode
    {
        int val;
        LeetCode_24.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, LeetCode_24.ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head)
    {
        if(head==null || (head!=null && head.next==null))
            return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null)
        {
            //临时节点
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            //处理交换逻辑
            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;

            //更新cur
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args)
    {

    }
}
