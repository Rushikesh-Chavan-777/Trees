import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javafx.scene.media.SubtitleTrack;
import javafx.util.Pair;

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
public class master {
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
    
static class Pair<T, U> {
    T first;
    U second;

    // Constructor
    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Getters
    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}


public static void preinout(Node root) {



    Stack<Pair<Node, Integer>> st = new Stack<>();
    if (root == null) {
        return;
    }

    ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
    ArrayList<ArrayList<Integer>> in = new ArrayList<>();
    ArrayList<ArrayList<Integer>> post = new ArrayList<>();

    // Push the root node and its state as "preorder" (state is represented by 0 for preorder)
    st.push(new Pair<>(root, 0));

    while (!st.isEmpty()) {
        Pair<Node, Integer> current = st.pop();
        Node node = current.getFirst();
        Integer state = current.getSecond();

        if (state == 0) {  // Preorder
            if (node != null) {
                ArrayList<Integer> preList = new ArrayList<>();
                preList.add(node.data);
                pre.add(preList);

                // Push the node with state "inorder" (state is 1 for inorder)
                st.push(new Pair<>(node, 1));

                // Push the right and left children with state "preorder" (state is 0)
                if (node.right != null) st.push(new Pair<>(node.right, 0));
                if (node.left != null) st.push(new Pair<>(node.left, 0));
            }
        } else if (state == 1) {  // Inorder
            if (node != null) {
                ArrayList<Integer> inList = new ArrayList<>();
                inList.add(node.data);
                in.add(inList);

                // Push the node with state "postorder" (state is 2 for postorder)
                st.push(new Pair<>(node, 2));

                // Push the right child with state "inorder" (state is 1)
                if (node.right != null) st.push(new Pair<>(node.right, 1));
            }
        } else if (state == 2) {  // Postorder
            if (node != null) {
                ArrayList<Integer> postList = new ArrayList<>();
                postList.add(node.data);
                post.add(postList);
            }
        }
    }
}    



public static int maxheight(Node root) {
    //here we shall use a recursive approach

    if (root == null) {
        return 0;
    }
    int left_height = maxheight(root.left);
    int right_height = maxheight(root.right);

    return 1 + Math.max(left_height, right_height);
}
public static int isBalanced(Node root) {
    //basically, a balanced tree is that in which the diff in left and right branches is always less than or equals to 1
    //lets leverage the same max heigh code and use here according
    //we shall try to return -1 is at all it is ot balanced acc to our def of balanced
    if(root == null) {
        return 0;
    }
    int left_height = isBalanced(root.left);
    if(left_height == -1) return -1;
    int right_height = isBalanced(root.right);
    if(right_height == -1) return -1;
    if(Math.abs(right_height - left_height) > 1) {
        return -1;
    }  
    return 1 + Math.max(left_height, right_height);
}

//finding max diamter 
static int max = 0;
public static int diameter(Node root) {
    //here, we have to take the largest distance we can possible get between tow nodes and return it as the diameter 
    //so, I have created a global variable that is called Max, we shal leverage that 
    if(root == null) {
        return 0;
    }
    int left_height  = diameter(root.left);
    int right_height = diameter(root.right);
    max = Math.max(left_height + right_height, max);
    return 1 + Math.max(left_height, right_height);
}
public static int getdiameter(Node root) {
    max = 0;
    diameter(root);
    return max;
}


//maximum path sum in binary tree
static int max_sum = 0;
public static int maxpathsum(Node root) {
    if(root == null) {
        return 0;
    }

    int left_sum = Math.max(0, maxpathsum(root.left));  //ignoring negative paths
    int right_sum = Math.max(0, maxpathsum(root.right));

    max_sum = Math.max(left_sum + right_sum + root.data , max_sum);
    return root.data + Math.max(left_sum, right_sum);

}
public static int getmaxpathsum(Node root) {
    max_sum = 0;
    maxpathsum(root);
    return max_sum;
}
//similar trees
public static boolean similartrees(Node root1, Node root2) {
    //using recursion to compare
    if(root1 == null && root2 == null) {
        return true;
    }
    if (root1 == null || root2 == null) {
        return false;
    }
    boolean lefter = similartrees(root1.left, root2.left);
    boolean righter = similartrees(root1.right, root2.right);

    return root1.data == root2.data && lefter && righter;
}

//zigzag trees
//bascically here we shall first write our level order traversal and then alter ita ccording to our need. Small tweeking should do 
public static ArrayList<ArrayList<Integer>> zigzag(Node root) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    if(root == null) {
        return list;
    }
    Queue<Node> q = new LinkedList<Node>();
    boolean lefttoright = true;
    q.offer(root);
    while(!q.isEmpty()) {
        int level_size = q.size();
        ArrayList<Integer> sub_list = new ArrayList<Integer>();
        for(int i = 0; i < level_size; i++) {
            Node rooter = q.poll();
            // sub_list.add(rooter.data);
            if(lefttoright) sub_list.add(rooter.data);
            else{
                sub_list.add(0, rooter.data);
            } 

            if(rooter.left != null) {
                q.add(rooter.left);
            }
            if(rooter.right != null) {
                q.add(rooter.right);
            }
        }
        lefttoright = ! lefttoright;
        list.add(sub_list);
    }
    return list;
}
//


    public static void main(String[] args) {
        System.out.println("Hi");
    }
    
}
