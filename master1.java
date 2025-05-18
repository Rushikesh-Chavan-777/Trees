//defining the tree structure as a whole

//import java.util.ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data1){
        this.data = data1;
        this.left = null;
        this.right = null;
    }
};

    //preorder
public class master1 {
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    //post oprder
    public static void postorder(Node root){
        if(root == null){
            return;
            }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    //inorder
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    //level order
    public static ArrayList<ArrayList<Integer>> levelorder(Node root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level_size = q.size();
            ArrayList<Integer> lister = new ArrayList<Integer>();
            for(int i = 0; i < level_size; i++) {
                Node rooter = q.poll();
                lister.add(rooter.data);
                if(rooter.left != null) {
                    q.offer(rooter.left);
                }
                if(rooter.right != null){
                    q.offer(rooter.right);
                }
            }
            list.add(lister);
        }
        return list;
    }
    //preorder tarversal using iterative method
    //for this, we can use a stack accordingly and keep iusing the LIFO properlty of stacks in the correct order
    public static void preorder_iterative(Node root) {
        //defining the stqack data structure
        if(root == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node s = stack.pop();
            System.out.println(s.data);
            if(s.right != null) {
                stack.push(s.right);
            }
            if(s.left != null) {
                stack.push(s.left);
            }
        }
    }
    //inorder traversal using an iterative approach
    // the diea here is basically to create the recurssion stack as an actual stack and leverage that for an iterative way
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        Stack<Node> 
    }



    
    public static void main(String[] args) {
        System.out.println("Hi");
    }
    
}
