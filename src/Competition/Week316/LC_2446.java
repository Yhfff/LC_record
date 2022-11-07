package Competition.Week316;

/**
 * Problem1
 * 判断两个事件是否有冲突
 */
public class LC_2446 {
    public static void main(String[] args) {
        String s1 = "02:00";
        String s2 = "02:00";
        System.out.println(s1.compareTo(s2));
    }

    //直接进行字符串的比较 str1.compareTo(str2)
    public boolean haveConflict(String[] event1, String[] event2){
        /**
         * 利用交集的概念
         * 1. event1的开始时间段<=event2的结束时间段
         * 2. event1的结束时间段>=event2的开始时间段
         */
        return event1[0].compareTo(event2[1])<=0 && event1[1].compareTo(event2[0])>=0;
    }

    /**
     * 这样写默认event1发生在event2之前
     * event1 = ["14:13","22:08"] event2 = ["02:40","08:08"]
     * 应该返回false 但是返回了true
     * 只考虑了event1的结束时间段>=event2的开始时间段
     */
    public boolean haveConflict_2(String[] event1, String[] event2) {
        String time1 = event1[1];
        String time2 = event2[0];
        int hour1 = Integer.parseInt(time1.substring(0,2));
        int hour2 = Integer.parseInt(time2.substring(0,2));
        if(hour1<hour2)
            return false;
        else if(hour1>hour2)
            return true;
        else{ //hour1==hour2
            int minute1 = Integer.parseInt(time1.substring(3,5));
            int minute2 = Integer.parseInt(time2.substring(3,5));
            if(minute1>=minute2) return true;
            else return false;
        }
    }
}
