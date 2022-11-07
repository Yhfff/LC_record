package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和
public class LeetCode_15
{
    //固定三个数的顺序 -》 排序
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if(length<3) return ans;
        Arrays.sort(nums);
        for(int i=0;i<length;i++)
        {
            //第一个数大于0 直接跳过
            if(nums[i]>0) return ans;
            //去重 i>0防止i=0时进入if报错 老大去重
            if(i>0 && nums[i]==nums[i-1]) continue; //[1,2,2,2,3]
            //双指针
            int left = i + 1;
            int right = length - 1;
            int target = -nums[i];
            while(right>left)
            {
                if(nums[right]+nums[left]==target)
                {
//	    			List<Integer> temp = new ArrayList<>();
//	    			temp.add(nums[i]);
//	    			temp.add(nums[left]);
//	    			temp.add(nums[right]);

                    //Arrays.asList 将数组转化为列表
                    List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
                    ans.add(temp);

                    //去重  ？
                    while(right>left && nums[right]==nums[right-1])  //老三去重
                        right--;
                    while(right>left && nums[left]==nums[left+1])  //老二去重
                        left++;

                    //找到答案 双指针收缩 否则陷入死循环
                    right--;
                    left++;

                }else if(nums[right]+nums[left]<target)
                {
                    left++;
                }else
                {
                    right--;
                }
            }
        }
        return ans;
    }
}
