package Stack_Queue;

import java.util.Stack;

//有效的括号
public class LC_20
{
    public static boolean isValid(String s)
    {
        int length = s.length();
        if(length==1) return false;
        int flag = 0;
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<length;i++) {
            char temp = s.charAt(i);
            switch (temp) {
                /*
                若碰到左括号 将左括号加入栈中 会如下所示产生冗余代码
                可以在碰到左括号 将对应的右括号加入栈中 之后直接判断是否相等即可
                if (stack.isEmpty() || stack.peek() != temp)
                    return false;
                 */
                case '(':
                case '{':
                case '[':
                    stack.add(temp);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') //当需要获取栈中元素时 首先要判断栈是否为空
                        return false;
                    else stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[')
                        return false;
                    else stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{')
                        return false;
                    else stack.pop();
                    break;
            }
        }
        if (!stack.isEmpty()) return false; //若是合法字符串 遍历完成后栈一定为空
        return true;
    }
    /*
    特殊情况：
    1.)  ){
    2.((
    3.([])(
     */
    public static void main(String[] args)
    {
        String s = "((";
        System.out.println(isValid(s));
    }
}

