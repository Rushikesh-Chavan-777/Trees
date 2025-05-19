public class pathsum {
       // maximum path sum in binary tree
    static int max_sum = 0;

    public static int maxpathsum(Node root) {
        if (root == null) {
            return 0;
        }

        int left_sum = Math.max(0, maxpathsum(root.left)); // ignoring negative paths
        int right_sum = Math.max(0, maxpathsum(root.right));

        max_sum = Math.max(left_sum + right_sum + root.data, max_sum);
        return root.data + Math.max(left_sum, right_sum);

    }

    public static int getmaxpathsum(Node root) {
        max_sum = 0;
        maxpathsum(root);
        return max_sum;
    }
    
}
