public class balancedtree {

    public static int isBalanced(Node root) {
        // basically, a balanced tree is that in which the diff in left and right
        // branches is always less than or equals to 1
        // lets leverage the same max heigh code and use here according
        // we shall try to return -1 is at all it is ot balanced acc to our def of
        // balanced
        if (root == null) {
            return 0;
        }
        int left_height = isBalanced(root.left);
        if (left_height == -1)
            return -1;
        int right_height = isBalanced(root.right);
        if (right_height == -1)
            return -1;
        if (Math.abs(right_height - left_height) > 1) {
            return -1;
        }
        return 1 + Math.max(left_height, right_height);
    }
    
}
