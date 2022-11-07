package Stack_Queue;

import java.util.Stack;

//删除字符串中的所有相邻重复项
public class LeetCode_1047
{
    public static String removeDuplicates(String s)
    {
        //ArrayDeque
        //ArrayDeque<Character> deque = new ArrayDeque<>();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
           char temp = s.charAt(i);
           if(stack.isEmpty() || temp!=stack.peek())
               stack.add(temp);
           else
           {
               stack.pop();
           }
        }
        //遍历stack
        //1. 集合遍历方式 感觉是以队列的方式输出栈
//        StringBuilder res = new StringBuilder(); //StringBuilder.toString()转化为字符串
//        for(Character c:stack)
//        {
//            res.append(c);
//        }

        // 其实不需要使用StringBuilder 使用string即可
        String res = "";
        while (!stack.isEmpty())
        {
            res = stack.pop() + res;
        }


//        System.out.println("--------------------------");
//        //2. 栈弹出遍历
//        while (!stack.isEmpty())
//            System.out.println(stack.pop());
        return res;
    }

    //快慢指针
    public static String removeDuplicates_2(String s)
    {
        char str[] = s.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast<s.length())
        {
            //用fast覆盖slow
            str[slow] = str[fast];
            if(slow>0 && str[slow]==str[slow-1])
            {
                //slow往后退一步 fast往前进一步 然后再用fast覆盖slow 即可把两个重复元素均删除
                slow--;
            }else
            {
                slow++;
            }
            fast++;
        }
        return new String(str,0,slow);
    }

    public static void main(String[] args)
    {
        String str = "abbacca";
        String res = removeDuplicates_2(str);
        System.out.println(res);
    }
}
