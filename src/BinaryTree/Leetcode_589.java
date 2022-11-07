package BinaryTree;
import java.util.*;

//N叉树的前序与后序(590)遍历
public class Leetcode_589
{
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val)
        {
            val = _val;
        }

        public Node(int _val, List<Node> _children)
        {
            val = _val;
            children = _children;
        }
    };

    //递归
    public List<Integer> preorder(Node root)
    {
        List<Integer> ans = new ArrayList();
        pre(root,ans);
        return ans;
    }

    public void pre(Node node,List<Integer> ans)
    {
        //递归终止条件
        if(node==null) return;
        //单层循环逻辑
        ans.add(node.val);//父
        //使用for循环
        for(int i=0;i<node.children.size();i++)
            pre(node.children.get(i),ans);//左右
    }

    //迭代
    public List<Integer> preorder_2(Node root)
    {
        List<Integer> ans = new ArrayList();
        Stack<Node> stack = new Stack<>();
        if(root!=null)stack.push(root);

        while (!stack.isEmpty())
        {
            Node temp = stack.pop();
            ans.add(temp.val);
            //从右往左加
            for(int i=temp.children.size()-1;i>=0;i--)
            {
                stack.push(temp.children.get(i));
            }
        }
        return ans;
    }

    //n叉树的后序遍历
    //递归
    public List<Integer> postorder(Node root)
    {
        List<Integer> ans = new ArrayList();
        post(root,ans);
        return ans;
    }

    //左右父
    public void post(Node root,List<Integer> ans)
    {
        if(root==null) return;
        for(int i=0;i<root.children.size();i++)
        {
            post(root.children.get(i),ans);
        }
        ans.add(root.val);
    }

    //迭代
    //根据前序修改
    public List<Integer> postorder_2(Node root)
    {
        List<Integer> ans = new ArrayList();
        Stack<Node> stack = new Stack<>();
        if(root!=null)stack.push(root);

        while (!stack.isEmpty())
        {
            Node temp = stack.pop();
            ans.add(temp.val);//父
            //父右左
            for(int i=0;i<temp.children.size();i++)
            {
                stack.push(temp.children.get(i));//右 左
            }
        }
        Collections.reverse(ans);
        return ans;
    }


}
