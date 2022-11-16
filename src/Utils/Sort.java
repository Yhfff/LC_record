package Utils;

/**
 * 排序
 */
public class Sort {
    //1. 归并排序
    public static int[] mergeSort(int[] nums,int low,int high){
        //分治——先分后合
        int mid = (low+high)/2;

        if(low<high){
            //分
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            //合
            merge(nums,low,mid,high);
        }
        return nums;
    }

    public static void merge(int []nums,int low,int mid,int high){
        //中间数组 长度为high-low+1
        int len = high-low+1;
        int temp[] = new int[len];

        int i = low;//左边有序子数组第一个数的索引
        int j = mid+1;//右边有序子数组第一个数的索引
        int index = 0;//temp数组的开始索引

        while(i<=mid && j<=high){
            if(nums[i]>nums[j]){
                temp[index++] = nums[j++];
            }else
                temp[index++] = nums[i++];
        }

        /**
         * 上述while终止的条件为i>mid或者j>high
         * 未处理到的数需直接复制到temp数组中
         */
        // 把左边剩余的数移入数组
        while(i<=mid)
            temp[index++] = nums[i++];
        //把右边剩余的数移入数组
        while(j<=high)
            temp[index++] = nums[j++];

        //将temp数组覆盖至原数组上 k+low开始
        for(int k=0;k<len;k++){
            nums[k+low] = temp[k];
        }
    }




    //主函数用于测试排序算法的正确性
    public static void main(String[] args) {
        int[] data = new int[] { 5, 3, 6, 2, 1, 9, 4, 8,7};

        mergeSort(data,0,data.length-1);

        for(int i=0;i<data.length;i++){
            System.out.printf("%-2d",data[i]);
        }
    }
}
