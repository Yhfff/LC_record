package Stack_Queue;

import java.util.ArrayDeque;

//逆波兰表达式求值
public class LC_150
{
    //后缀表达式 运算法放在操作数的后面
    public static int evalRPN(String[] tokens)
    {
        //既可用作stack 还可用作queue
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //String operators[] = {"+","-","*","/"};
        for(int i=0;i< tokens.length;i++)
        {
            String str = tokens[i];
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))   //判断是否是运算符 不能使用==判断字符串是否相等
            {
                int num1 = deque.pop();
                int num2 = deque.pop();
                //四个if语句
                switch (str)
                {
                    case "+":
                        deque.push(num1+num2);
                        break;
                    case "-":
                        deque.push(num2-num1);
                        break;
                    case "*":
                        deque.push(num1*num2);
                        break;
                    case "/":
                        deque.push(num2/num1);
                        break;
                }

            }else
            {
                deque.push(Integer.valueOf(str));
            }

        }
        return deque.pop();
    }

    public static void main(String[] args)
    {
        String tokens[] =  {"2","1","+","3","*"} ;
        int res = evalRPN(tokens);
//        for(String str:tokens)
//        {
//            System.out.println(str);
//            System.out.println(str.indexOf("2"));
//            if(str.indexOf("2")==0)
//                System.out.println("2222");
//        }
        System.out.println(res);



    }
}
