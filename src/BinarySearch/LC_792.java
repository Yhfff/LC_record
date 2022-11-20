package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 11.17 每日一题
 * 匹配子序列的单词数
 */
public class LC_792 {
    /**
     * 二分查找加速搜索过程
     */
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer> []index = new List[26];
        for(int i=0;i<26;i++){
            index[i] = new ArrayList<>();
        }
        //index[i]-》List： 存储的是每一个字符从前到后出现的位置
        for(int i=0;i<s.length();i++){
            index[s.charAt(i)-'a'].add(i);
        }

        int cnt = words.length;
        for(String word:words){
            int len = word.length();
            if(len>s.length()){
                cnt--;
                continue;
            }
            int target = -1;
            for(int i=0;i<len;i++){
                char chr = word.charAt(i);
                //字符chr不存在 或者最后一次出现的位置下标<=target 说明都不符合
                if(index[chr-'a'].isEmpty() || index[chr-'a'].get(index[chr-'a'].size()-1)<=target){
                    cnt--;
                    break;
                }
                target = binarySearch(index[chr-'a'],target);
            }
        }
        return cnt;

    }

    //二分查找
    public int binarySearch(List<Integer> list,int target){
        int left = 0,right = list.size()-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(list.get(mid)>target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return list.get(left);
    }




    //暴力
    public int numMatchingSubseq2(String s, String[] words) {
        int cnt = words.length;
        int index;
        for(String word:words){
            index = s.indexOf(word.charAt(0));
            if(index<0) {
                cnt--;
                continue;
            }
            for(int i=1;i< word.length();i++){
                //int temp = s.substring(index+1).indexOf(word.charAt(i));
                //indexOf(chr,startIndex)
                index = s.indexOf(word.charAt(i),index+1);
                if(index<0){
                    cnt--;
                    break;
                }
               // index += temp+1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "abcda";
        System.out.println(s.substring(1));
    }
}
