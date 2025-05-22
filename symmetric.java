import java.util.ArrayList;

public class symmetric {

        public static boolean isSymmetric(Node root) {
        // here we shall trya nd use a helper function that takes both the sides of the
        // tree and analyses if the tree is symmetric or not
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data) {
            return false;
        }
        boolean lefter = isSymmetricHelper(left.left, right.right);
        boolean middle = isSymmetricHelper(left.right, right.left);
        return lefter && middle;

    }

   
    
}
