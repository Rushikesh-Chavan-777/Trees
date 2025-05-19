public class diameter_tree {
        // finding max diamter
    static int max = 0;

    public static int diameter(Node root) {
        // here, we have to take the largest distance we can possible get between tow
        // nodes and return it as the diameter
        // so, I have created a global variable that is called Max, we shal leverage
        // that
        if (root == null) {
            return 0;
        }
        int left_height = diameter(root.left);
        int right_height = diameter(root.right);
        max = Math.max(left_height + right_height, max);
        return 1 + Math.max(left_height, right_height);
    }

    public static int getdiameter(Node root) {
        max = 0;
        diameter(root);
        return max;
    }
    
}
