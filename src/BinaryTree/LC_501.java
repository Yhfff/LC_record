package BinaryTree;

import java.util.*;
import java.util.stream.Collectors;

//二叉搜索树中的众数
public class LC_501
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 利用BST的特性 不使用额外空间
     * BST中序遍历是有序的 在有序数组中找到众数 一定是相邻两个元素比较 pre cur
     */
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    ArrayList<Integer> resList = new ArrayList<>();
    public int[] findMode(TreeNode root)
    {
        traverse(root);
        int res[] = new int[resList.size()];
        for(int i=0;i<resList.size();i++)
            res[i] = resList.get(i);
       // return resList.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    //只需要遍历一遍树 而不是两遍 如果众数只有一个 那么遍历一次足矣
    public void traverse(TreeNode cur)
    {
        if(cur==null) return;
        traverse(cur.left);

        //计数
        if(pre==null || pre.val!= cur.val)
            count = 1;
        else count++;
        //更新maxCount
        if(count>maxCount)
        {
           resList.clear();//清空 之前存储的都失效
           resList.add(cur.val);
           maxCount = count;
        }else if(count==maxCount)
            resList.add(cur.val);
        pre = cur;

        traverse(cur.right);
    }


    /**
     * 普通二叉树寻找众数的写法
     * 但是对于二叉搜索树(BST) 可以利用BST的特性 不使用额外空间
     */
    Map<Integer,Integer> map = new HashMap<>();
    List<Integer> value = new ArrayList<>(); //存放答案的list
    public int[] findMode2(TreeNode root)
    {
        if(root==null) return value.stream().mapToInt(Integer::intValue).toArray(); //使用流Stream(JAVA 8新功能)的方法将list转为数组
        traverse2(root); //map赋值

        /**
         * map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList())
         * Map.Entry.comparingByValue()
         * 默认是从小到大排序
         */
        List<Map.Entry<Integer,Integer>> mapList = map.entrySet().stream().
                sorted((c1,c2)->c2.getValue().compareTo(c1.getValue()))  //lambda表达式配合Stream
                .collect(Collectors.toList());  //根据value(即值出现的次数)由大到小排序

        value.add(mapList.get(0).getKey());
        //将最高的频率加入list
        for(int i=1;i<mapList.size();i++)
        {
            if(mapList.get(i).getValue()==mapList.get(i-1).getValue())  //次数相同 说明众数不止一个
            {
                value.add(mapList.get(i).getKey());
            }else  //一旦次数不同 直接break
                break;
        }
        return value.stream().mapToInt(Integer::intValue).toArray();
//        value = new ArrayList<>(map.values());
//        Collections.sort(value);

        //int key;

        //map根据value找key
//        for(Map.Entry<Integer,Integer> entry:map.entrySet())
//        {
//            if(value.get(value.size()-1) == entry.getValue())
//                key = entry.getKey();
//        }
    }

    /**
     * 遍历 将key-value存储至map中
     * 其实这边使用前中后序遍历都可以 因为只是将值放在map中
     */
    public void traverse2(TreeNode root)
    {
        if(root==null) return;
        traverse(root.left);  //左
        map.put(root.val, map.getOrDefault(root.val,0)+1); //中
        traverse(root.right); //右
    }

}
