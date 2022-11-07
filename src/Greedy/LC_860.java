package Greedy;

//柠檬水找零
public class LC_860 {
    public static void main(String[] args) {

    }

    public static boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5) cnt5++;   //遇到5块钱 不用找 直接收下 cnt5++
            else if(bills[i]==10){  //遇到10块钱
                if(cnt5<=0) return false;  //如果没有5块钱找 那么return false
                else {
                    cnt5--;// 找一张5块 加一张10块
                    cnt10++;
                }
            }else {  //遇到20块 需要找10+5 或者 5+5+5
//                if(cnt10>0 && cnt5>0){
//                    cnt5--;
//                    cnt10--;
//                }else if(cnt10>0 && cnt5<=0) return false;
//                else if(cnt10<=0 && cnt5>0 && cnt5<3)
//                    return false;
//                else if(cnt10<=0 && cnt5>=3)
//                    cnt5 = cnt5-3;
                if(cnt10>0){  // 如果有10块 优先把10块找出去 因为5块用处更大
                    if(cnt5<=0)  // 如果此时没有5块 return false
                        return false;
                    else{  //否则找出去一张10块 一张5块
                        cnt5--;
                        cnt10--;
                    }
                }else {  //没有10块 只能找3张5块
                    if(cnt5>=3) cnt5=cnt5-3;
                    else return false;  //没有3张5块 return false
                }
            }
        }
        return true;
    }
}
