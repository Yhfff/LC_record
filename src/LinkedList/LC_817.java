package LinkedList;

import java.util.HashSet;
import java.util.Set;

//10.12 每日一题
//链表组件
public class LC_817
{
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();  //用set存储便于查询
        for(int i=0;i<nums.length;i++)
            set.add(nums[i]);
        int res = 0;
        boolean flag = false;//前一个节点在不在数组中
        //int len = 0;
        while (head!=null)
        {
            if(!set.contains(head.val)) //此时节点数组中不存在 指针后移 flag=false
                flag = false;
            else {//节点在数组中存在
                //感觉是遇到连续的起点res就加1
                if(flag==false)  //前一个不存在 即表示当前节点是新连续的起点
                    res++;
                flag = true;
            }
            head = head.next;
        }
        return res;
    }
}
