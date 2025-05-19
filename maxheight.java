public class maxheight {
        public static int maxheight1(Node root) {
        // here we shall use a recursive approach

        if (root == null) {
            return 0;
        }
        int left_height = maxheight1(root.left);
        int right_height = maxheight1(root.right);

        return 1 + Math.max(left_height, right_height);
    }
    
}
