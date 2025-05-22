import java.util.ArrayList;

public class getroottonode {

        // printing from root to nod epath in a tree
    public static ArrayList<Integer> getRootToNode(Node root, int data) {
        ArrayList<Integer> arr = new ArrayList<>();
        getRootToNodeHelper(root, arr, data);
        return arr;
    }

    public static boolean getRootToNodeHelper(Node root, ArrayList<Integer> arr, int data) {
        if (root == null) {
            return false;
        }
        arr.add(root.data);
        if (root.data == data) {
            return true;
        }
        boolean left = getRootToNodeHelper(root.left, arr, data);
        boolean right = getRootToNodeHelper(root.right, arr, data);
        if (left || right) {
        }
        return false;
    }
    
}
