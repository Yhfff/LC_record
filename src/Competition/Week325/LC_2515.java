package Competition.Week325;

public class LC_2515 {
    public int closetTarget(String[] words, String target, int startIndex) {
        int len = words.length;
        int cnt1 = 0, cnt2 = 0;
        //往后找
        for(int i = 0;i < len;i++){
            int index1 = (i+startIndex) % len;
            if(words[index1].equals(target))
                break;
            else {
                cnt1++;
            }
        }
        // 往前找
        for(int i = 0;i < len;i++){
            int index2 = (startIndex-i+len) % len;
            if(words[index2].equals(target))
                break;
            else {
                cnt2++;
            }
        }
        return (cnt1==len && cnt2==len) ? -1 : Math.min(cnt1, cnt2);
    }
}
