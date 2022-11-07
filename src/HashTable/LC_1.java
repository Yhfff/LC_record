package HashTable;
//两数相加
import java.util.HashMap;
import java.util.Map;

public class LC_1
{
    public static int[] twoSum(int[] nums, int target)
    {
        int ans[] = new int[2];
        int length = nums.length;
        //由于需要存放值和下标 所以使用map
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<length;i++)
        {
            //先查再插
            int temp = target - nums[i];//更新target
            if(hashMap.containsKey(temp))
            {
                int index = hashMap.get(temp);
                ans[0] = i;
                ans[1] = index;
                return ans;
            }
            hashMap.put(nums[i], i); //将值和下标都存入
        }
        return ans;
    }


    //暴力
//	public static int[] twoSum(int[] nums, int target)
//	{
//		int ans[] = new int[2];
//		int length = nums.length;
//		for(int i=0;i<length-1;i++)
//		{
//			for(int j=i+1;j<length;j++)
//			{
//				if((nums[i]+nums[j])==target)
//				{
//					ans[0] = i;
//					ans[1] = j;
//				}
//			}
//		}
//		return ans;
//	}
}
