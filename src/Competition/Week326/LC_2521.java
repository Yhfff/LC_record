package Competition.Week326;

import java.util.HashSet;
import java.util.Set;

/**
 *  数组乘积中的不同质因数数目
 */
public class LC_2521 {
    Set<Integer> factors = new HashSet<>();
    public int distinctPrimeFactors(int[] nums) {
        for(int num : nums){
            calc(num);
        }
        return factors.size();
    }

    public void calc(int num){
        for (int factor = 2; factor < num; factor++) {
            while (num % factor == 0 && num > factor) {
                factors.add(factor);
                num = num / factor;
            }
        }
        factors.add(num);
    }


}
