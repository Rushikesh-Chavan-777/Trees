import java.util.Stack;

public class preorder_iterative {
        //preorder tarversal using iterative method
    //for this, we can use a stack accordingly and keep iusing the LIFO properlty of stacks in the correct order
    public static void preorder_iterative1(Node root) {
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
    
}
