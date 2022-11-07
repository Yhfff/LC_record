package Stack_Queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// 前K个高频元素
public class LC_347
{
    /*
    1. 统计元素出现频率  ——map
    2. 对频率排序  ——大顶堆 （堆头是最大元素） 优先队列 此题使用小顶堆
    3. 找出前K个高频元素
     */
    public static int[] topKFrequent(int[] nums, int k)
    {
        //定义map统计频率 key是值 value是次数
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
        {
            //当Map集合中有这个key时,就使用这个key值,如果没有就使用默认值defaultValue
            int count = map.getOrDefault(num,0);
            map.put(num,count+1);
//            if(map.containsKey(num))
//            {
//                int temp = map.get(num);
//                map.put(num,temp+1);
//            }else
//            {
//                map.put(num,1);
//            }
        }
        //遍历map并输出
        for (Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            System.out.println("key:"+entry.getKey()+"  value:"+ entry.getValue());
        }
        //定义小根堆 java PriorityQueue中默认是小根堆
        //根据value排序存储key

//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });
        //lambda表达式实现自定义排序
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            minHeap.add(entry);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        System.out.println("------------------------------------------------");
        //遍历小根堆
        for (Map.Entry<Integer,Integer> entry:minHeap)
        {
            System.out.println("key:"+entry.getKey()+"  value:"+ entry.getValue());
        }

        int ans[] = new int[k];
        //倒序插入结果数组中
        for(int i=k-1;i>=0;i--)
            ans[i] = minHeap.poll().getKey();
        return ans;
    }

    public static void main(String[] args)
    {
        int[] num = {1,1,1,2,2,3,4,4,4,4,5,5,5,5,5};
        int k = 3;
        int ans[] = new int[k];
        ans = topKFrequent(num,k);
        for(int i:ans)
            System.out.println(i);
    }
}
