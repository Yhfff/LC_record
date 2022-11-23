package CodeTop;

import org.omg.CORBA.MARSHAL;

import java.util.HashMap;
import java.util.Map;

/**
 * 11.23
 * CodeTop 1(频率最高)
 * 无重复字符的最长子串
 * 滑动窗口
 */
public class LC_3_1 {
    /**
     * 滑动窗口
     */
    public static int lengthOfLongestSubstring(String s){
        if(s.length()==0) return 0;
        int res = 1;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        for(int right=0;right<s.length();right++){
            char chr = s.charAt(right);
            if (map.containsKey(chr)) {
                left = Math.max(left,map.get(chr)+1);
            }
            //map中存放<字符，下标>
            map.put(chr,right);
            res = Math.max(right-left+1,res);
        }
        return res;
    }


    /**
     * 暴力+hashmap
     */
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length()==0) return 0;
        int res = 1;
        char chrs[] = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<chrs.length-1;i++){
            map.put(chrs[i],1);
            for(int j=i+1;j<chrs.length;j++){
                if(map.containsKey(chrs[j])){
                    res = Math.max(res,map.size());
                    map.clear();
                    break;
                }else {
                    map.put(chrs[j],1);
                }
            }
        }
        //还是需要比较一下，因为整个过程可能都没进入if(map.containsKey) -> 'au'
        return Math.max(res,map.size());
    }

    public static void main(String[] args) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('a',1);
        //System.out.println(map.get('b'));
        String s = "BWF";
        System.out.println(lengthOfLongestSubstring2(s));
    }
}
