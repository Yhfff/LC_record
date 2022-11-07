package HashTable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_349
{
    public static int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> set_1 = new HashSet<>();
        Set<Integer> res_set = new HashSet<>();
        for(int num:nums1)
            set_1.add(num);
        for(int num:nums2)
        {
            if(set_1.contains(num))
                res_set.add(num);
        }
        //将set list等转化为数组
        int res[] = new int[res_set.size()];
        int index = 0;
        for(int i:res_set)
            res[index++] = i;
        return res;
//		int cnt[] = new int[1001];
//		for(int num:nums1)
//		{
//			set_1.add(num);
//		}
//		for(int num:nums2)
//		{
//			set_2.add(num);
//		}
//		for(int num:set_1)
//		{
//			cnt[num]++;
//		}
//		for(int num:set_2)
//		{
//			cnt[num]++;
//		}
//		List<Integer> temp = new ArrayList<>();
//		for(int i=1;i<=1000;i++)
//		{
//			if(cnt[i]==2)
//			{
//				temp.add(i);
//			}
//
//		}
//		Object res[] = temp.toArray();
//		for(Object x:res)
//			System.out.println(x);
//		return cnt;

    }


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        int nums1[] = {1,2,2,1};
        int nums2[] = {2,2};
        int res[] = intersection(nums1, nums2);
        for(int i:res)
            System.out.println(i);

    }
}
