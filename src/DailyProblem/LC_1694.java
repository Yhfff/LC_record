package DailyProblem;

/**
 * 10.1每日一题 重新格式化电话号码
 * 典型模拟题
 */
public class LC_1694 {

    public static void main(String[] args) {
        String a = "1-23-45 67";
        System.out.println(reformatNumber(a));
    }


    public static String reformatNumber(String number) {
        String num = number.replace("-","")
                .replace(" ","");  // 不需要使用for循环 使用replace
        System.out.println(num);
//        for(int i=0;i<number.length();i++)
//        {
//            char temp = number.charAt(i);
//            if(temp=='-' || temp==' ') continue; //遇到空格和破折号
//            num += temp;
//        }
        StringBuilder ans = new StringBuilder();  //建议使用StringBuilder 速度比String要快
        int len = num.length();   //记录剩余的数字数量 当len<=4时特殊判断
        int index = 0;
        while (len>0){
            if(len>4){  //剩余长度大于4时 就直接取3个append + "-"
                ans.append(num.substring(index,index+3)+"-");
                index += 3;
                len -=3;
            }else {   //剩余长度<=4 同时也说明快到字符串尾巴了
                if(len==4){ //len==4 直接2+2
                    ans.append(num.substring(index,index+2) + "-" +
                            num.substring(index+2,index+4));
                }else{ // len=1,2,3 就直接全部取完即可
                    ans.append(num.substring(index,index+len));
                }
                break;
            }
        }
        return ans.toString();
    }

}
