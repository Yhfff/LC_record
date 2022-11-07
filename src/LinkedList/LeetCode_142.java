package LinkedList;
//环形链表 找到环的入口
public class LeetCode_142
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int x)
        {
          val = x;
          next = null;
        }
    }
    /*
      快慢指针判断是否有环
      快指针每次移动两个节点 慢指针每次移动一个节点
      慢指针一定在进入环的第一圈内被快指针追上
     */
    public static ListNode detectCycle(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null) //确定遍历终止条件
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) //相遇 说明有环
            {
                ListNode temp1 = head;
                ListNode temp2 = fast;
                while(temp1!=temp2)
                {
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                return temp1;
            }
        }
        return null;
    }
}
