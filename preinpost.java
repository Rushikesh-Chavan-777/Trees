import java.util.ArrayList;
import java.util.Stack;

public class preinpost {
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
public static void main(String[] args) {
    
}
    
}
