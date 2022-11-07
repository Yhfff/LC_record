package Greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

//K次取反后最大化的数组和
public class LC_1001
{
    public static void main(String[] args) {
        int nums[] = {-8,3,-5,-3,-5,-2};
        int k = 6;
        mySort(nums);
        for (int x:
            nums ) {
            System.out.println(x);

        }
        System.out.println(largestSumAfterKNegations(nums,k));
    }

    public static int largestSumAfterKNegations(int[] nums, int k)
    {
        int len = nums.length;
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray(); //使用流将数组按照绝对值大小排序
//        for(int i=0;i<len-1;i++)
//        {
//            for(int j=i+1;j<len;j++)
//            {
//                if(Math.abs(nums[j])>Math.abs(nums[i])) //后者绝对值比前者大 因此需要交换
//                {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }

        int res = 0;

        for(int i=0;i<len;i++)
        {
            //遇到负数 且还有次数 将负数转正
            if(nums[i]<0 && k>0)
            {
                nums[i] *= -1;
                k--;
            }
        }
        if(k%2==1) nums[len-1] *= -1;  //如果操作完所有的负数之后还有次数 则对最小的正数处理(即最后一个数)
        for(int x:nums) res+=x;
        return res;
    }


//    public static int largestSumAfterKNegations(int[] nums, int k) {
//        Arrays.sort(nums);
//        int res = 0;
//
//        for(int i=0;i<k;i++)
//        {
//            if(nums[i]<0) nums[i] = -nums[i];
//            else {
//                if((k-i)%2==0) break;
//                else {
//                     nums[i] = -nums[i];
//                     break;
//                }
//            }
//        }
//
//
//        for(int i=0;i<nums.length;i++)
//            res += nums[i];
//        return res;
//
//    }
//

    // 根据冒泡排序的思想 根据绝对值大小将数组排序
    public static void mySort(int[] nums)
    {
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(Math.abs(nums[j])>Math.abs(nums[i])) //后者绝对值比前者大 因此需要交换
                {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
