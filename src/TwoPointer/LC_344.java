package TwoPointer;

// 反转字符串
public class LC_344
{
    public static void reverseString(char[] s)
    {
        int left = 0;
        int right = s.length-1;
        while(left<right)
        {
            //swap(s,left,right);
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }

    public static void swap(char[] s,int i,int j)
    {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    //使用位运算 实现元素交换
    public static void bit_swap(int a,int b)
    {
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }


    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//		char a[] = {'a','b','c','d'};
//		swap(a,0,1);
//		System.out.println(a[0]);
        int a = 1;
        int b = 2;
        bit_swap(a,b);
        System.out.println(a);
        System.out.println(b);

        System.out.println(1^1);
    }
}
