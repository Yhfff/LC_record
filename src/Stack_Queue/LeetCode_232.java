package Stack_Queue;

import java.util.Stack;

//用栈实现队列
public class LeetCode_232
{
    class MyQueue
    {
        Stack<Integer> stackIn;
        Stack<Integer> stackOut;
        public MyQueue()
        {
            stackIn = new Stack<>(); //进栈
            stackOut = new Stack<>(); //出栈
        }
        public void push(int x) //队列中添加一个元素
        {
            stackIn.push(x);
        }

        public int pop() //弹出元素
        {
            /*
            如果stackOut存在元素 直接弹出即可
            否则将stackIn中的元素加至stackOut 再弹出
             */
            inToOut();
            return stackOut.pop();
        }

        public int peek()  //队列第一个元素
        {
            inToOut();
            return stackOut.peek();
        }

        public boolean empty() //是否为空
        {
            return (stackIn.isEmpty() && stackOut.isEmpty());
        }
        //pop与peek的共同代码
        public void inToOut()
        {
            if(!stackOut.isEmpty()) return;
            while(!stackIn.isEmpty())
            {
                stackOut.push(stackIn.pop());
            }
        }
    }

}
