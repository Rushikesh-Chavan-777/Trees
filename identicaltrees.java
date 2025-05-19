public class identicaltrees {
        // similar trees
    public static boolean similartrees(Node root1, Node root2) {
        // using recursion to compare
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean lefter = similartrees(root1.left, root2.left);
        boolean righter = similartrees(root1.right, root2.right);

        return root1.data == root2.data && lefter && righter;
    }
    
}
