public class searchbst {
    // This function searches for a node with
    // a specified value in a Binary Search Tree (BST).
    public Node searchBST(Node root, int val) {
        // Loop until either the tree is
        // exhausted (null) or the value is found.
        while (root != null && root.data != val) {
            // Check if the target value is
            // less than the current node's value.
            // If so, move to the left subtree
            // (values smaller than the current node).
            // Otherwise, move to the right subtree
            // (values larger than the current node).
            root = val < root.data ? root.left : root.right;
        }
        // Return the node containing the target value,
        // if found; otherwise, return null.
        return root;
    }

}
