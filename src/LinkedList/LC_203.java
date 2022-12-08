package LinkedList;
//移除链表元素
public class LC_203
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //可能会出现头节点就是我们要删除的节点 不添加虚拟头节点需要单独处理
    //1. 添加虚拟头节点
    public static ListNode removeElements(ListNode head, int val)
    {
        if(head==null) return head;
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null)
        {
            if(cur.val==val)
            {
                pre.next = cur.next;
            }
            else
                pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    //2. 不添加虚拟头节点
    public static ListNode removeElements_2(ListNode head, int val)
    {
        if(head==null) return head;
        while(head!=null && head.val==val)
            head = head.next;
        ListNode cur = head; //此时cur.val肯定不等于val
        while(cur!=null)
        {
            while(cur.next!=null && cur.next.val==val)
                cur.next = cur.next.next;
            cur = cur.next;
        }
        return head;
    }
}
