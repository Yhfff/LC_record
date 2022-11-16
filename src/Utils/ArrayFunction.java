package Utils;

import java.util.Arrays;

/**
 * 关于数组常用的函数
 */
public class ArrayFunction {
    //1. 二维数组排序
    public void sort(int a[][]){
        //仅按第一列元素升序排序
        //Arrays.sort(a, (e1, e2) -> (e1[0] - e2[0]));
        // 先按第一列元素升序排序，如果第一列相等再按第二列元素升序；
        Arrays.sort(a, (e1, e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
    }

    /**
     * 2. 求一维数组中逆序对(i,j)的个数
     * 逆序对：数组中 i<j && a[i]>a[j]
     *     (1) 暴力双重循环
     *     (2) 归并排序
     */
    public int reversePair(int a[]){


        return 1;
    }

}
