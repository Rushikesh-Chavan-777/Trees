public class inorder {
      public static void inorder1(Node root) {
        if(root == null) {
            return;
        }
        inorder1(root.left);
        System.out.println(root.data);
        inorder1(root.right);
    }
    
}
