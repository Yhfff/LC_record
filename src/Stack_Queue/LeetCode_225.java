package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 用队列实现栈
/*
1. 可以使用一个队列实现
2. 也可以使用两个队列实现
 */
public class LeetCode_225
{
    class MyStack
    {
        Queue<Integer> queue1;
        Queue<Integer> queue2;//辅助队列 用于存储除最后一个元素外的其余元素
        public MyStack()
        {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x)
        {
            queue2.add(x);
            while (!queue1.isEmpty())
            {
                queue2.add( queue1.poll());
            }
            Queue<Integer> queueTemp = new LinkedList<>();
            //交换queue1 和queue2 此时queue1已经是栈的访问顺序
            queueTemp = queue1;
            queue1 = queue2;
            queue2 = queueTemp;
        }

        public int pop()
        {
//            while(queue1.size()>1)
//            {
//                int val = queue1.poll();
//                queue2.add(val);
//            }
//            while(queue2.size()>0)
//            {
//                int val = queue2.poll();
//                queue1.add(val);
//            }
//            return queue1.poll();
            return queue1.poll();
        }

        public int top()
        {
            return queue1.peek();
        }

        public boolean empty()
        {
            return queue1.isEmpty();
        }
    }

    //使用一个双端队列实现
    class MyStack_2
    {
        Deque<Integer> queue;
        public MyStack_2()
        {
            queue = new ArrayDeque<>();
        }

        public void push(int x)
        {
            queue.addLast(x);
        }

        public int pop()
        {
            while(queue.size()>1)
            {
                queue.addLast(queue.peekFirst());
                queue.pollFirst();
            }
            return queue.pollFirst();
        }

        public int top()
        {
            return queue.peekLast(); //注意是peekLast 即从队尾弹出
        }

        public boolean empty()
        {
            return queue.isEmpty();
        }
    }
}
