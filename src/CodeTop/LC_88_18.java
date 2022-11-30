package CodeTop;

import java.util.Arrays;

/**
 *  CodeTop 18
 *  合并两个有序数组
 */
public class LC_88_18 {

    //暴力
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    //双指针 但借助了额外数组sort
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int sort[] = new int[m+n];
        int temp;
        while(i<m || j<n){
            if(i==m){
                //说明nums1以全部遍历完 取nums2
                temp = nums2[j++];
            }else if(j==n){
                //说明nums2已全部遍历完 取nums1
                temp = nums1[i++];
            }else if(nums1[i]<=nums2[j]){
                //nums1中的元素<=nums2的元素 取nums1
                temp = nums1[i++];
            }else
                temp = nums2[j++];
            //-1是因为上述的取数操作之后 i/j都有++操作
            sort[i+j-1] = temp;
        }
        for(int k=0;k<m+n;k++)
            nums1[k] = sort[k];
    }

    //不借助额外数组 直接在nums1上修改 逆向双指针 从后往前遍历 这样就不会被覆盖
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int len = m+n-1;
        while(i>=0 && j>=0){
            nums1[len--] = nums1[i]<=nums2[j]?nums2[j--]:nums1[i--];
        }
        //System.arraycopy(nums2,0,nums1,0,j+1);
        while(j>=0){
            nums1[len--] = nums2[j--];
        }
    }
}
