public class preorder {
        public static void preorder1(Node root) {
        if(root == null) {
            return;
        }
        System.out.println(root.data);
        preorder1(root.left);
        preorder1(root.right);
    }
    
}
