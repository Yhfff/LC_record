package TwoPointer;
//移除元素
public class LC_27
{
    //双指针 （快慢指针）
    // 数组的元素在内存地址中是连续的，不能单独删除数组中的某个元素，只能覆盖
    public static int removeElement(int[] nums, int val)
    {
        int slowIndex = 0;
        for(int fastIndex=0;fastIndex<nums.length;fastIndex++)
        {
            if(nums[fastIndex]!=val)
            {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;

    }
}
