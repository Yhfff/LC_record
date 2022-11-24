package CodeTop;

/**
 * 11.23
 * CodeTop2
 * 反转链表
 */
public class LC_206_2 {
    public class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
       // ListNode dummy = null;//虚拟头节点
        ListNode cur = head, pre = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head){
        if(head==null) return null;
        return recursion(head,null);

    }

    public ListNode recursion(ListNode cur,ListNode pre){
        if(cur==null) return pre;
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;
        return recursion(cur,pre);
    }

}
