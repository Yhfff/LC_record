package Greedy;

import java.util.Arrays;

//分发饼干
public class LC_455
{
    public static void main(String[] args)
    {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        int res = findContentChildren(g,s);
        System.out.println(res);
    }

    /*
    尽可能不要浪费饼干的尺寸 避免使用一个大饼干去满足一个小食量的孩子
    两种贪心策略：
    1. 优先用大饼干满足大食量的孩子
    2. 优先用小饼干满足小食量的孩子
     */
    //优先用大饼干满足大食量的孩子
    public static int findContentChildren(int[] g, int[] s)
    {
        int count = 0;
        Arrays.sort(g); //孩子的胃口
        Arrays.sort(s); //饼干的尺寸
        int index = s.length-1;
        for(int i=g.length-1;i>=0;i--)  //遍历g[]数组 需要思考
        {
            if(index >= 0 && s[index] >= g[i])
            {
                count++;
                index--;  //采用index自减的方式控制饼干数组的遍历
            }
        }
        return count;
    }

    //优先用小饼干满足小食量的孩子
    public static int findContentChildren2(int[] g, int[] s)
    {
        int res = 0;
        Arrays.sort(g); //孩子的胃口
        Arrays.sort(s); //饼干的尺寸
        int index = 0;
        for(int i=0;i<s.length;i++) //遍历s数组
        {
            if(index < g.length && s[i] >= g[index])
            {
                res++;
                index++;
            }
        }
        return res;
    }


}
