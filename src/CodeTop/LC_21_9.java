package CodeTop;


/**
 * CodeTop 9
 * 合并两个有序链表
 * 与LC_88比较
 */
public class LC_21_9 {
    public static class ListNode
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //直接套用LC_88 merge2双指针的方法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(-1,null);
        ListNode cur1 = list1, cur2 = list2, cur = merge;
        while(cur1!=null || cur2!=null){
            if(cur1==null){
                //list1遍历完
                cur.next = cur2;
                cur2 = cur2.next;
            }else if(cur2==null){
                //list2遍历完
                cur.next = cur1;
                cur1 = cur1.next;
            }else if(cur1.val<=cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        return merge.next;
    }

    //递归
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }else {
            list2.next = mergeTwoLists2(list2.next, list1);
            return list2;
        }
    }
}
