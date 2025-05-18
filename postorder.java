public class postorder {
     public static void postorder1(Node root){
        if(root == null){
            return;
            }
        postorder1(root.left);
        postorder1(root.right);
        System.out.println(root.data);
    }
    
}
