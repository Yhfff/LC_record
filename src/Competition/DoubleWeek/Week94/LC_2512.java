package Competition.DoubleWeek.Week94;

import java.util.*;
import java.util.stream.Collectors;

public class LC_2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> pos = new HashSet<>();
        Set<String> neg = new HashSet<>();
        for(String str : positive_feedback)
            pos.add(str);
        for(String str : negative_feedback)
            neg.add(str);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < student_id.length;i++){
            int score = 0;
            String[] rep = report[i].split(" ");
            for(String word : rep){
                if(pos.contains(word))
                    score += 3;
                else if(neg.contains(word))
                    score -= 1;
            }
            map.put(student_id[i],score);
        }
        //获取entrySet
        Set<Map.Entry<Integer, Integer>> mapEntries = map.entrySet();
        //使用链表来对集合进行排序，使用LinkedList，利于插入元素
        List<Map.Entry<Integer, Integer>> result = new LinkedList<>(mapEntries);
        //自定义比较器来比较链表中的元素
        Collections.sort(result, new Comparator<Map.Entry<Integer, Integer>>() {
            //基于entry的值（Entry.getValue()），来排序链表
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int compare = o2.getValue().compareTo(o1.getValue());
                if (compare == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                } else {
                    return compare;
                }
            }
        });
        int tmp = 0;
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> newEntry : result) {
            if(tmp < k){
                ans.add(newEntry.getKey());
                tmp++;
            }
        }
        return ans;
    }
}
