import java.util.HashMap;
import java.util.Map;

public class buildpostin {

    //creating a tree when we are given post and in order traversals
public static Node buildpostin1(int[] postorder, int[] inorder) {
    //we shall creater a helper fuction to this
    //but, first lets create a map to apropriately get positions in the inorder arary
    Map<Integer, Integer> inMap = new HashMap<>();
    for(int i = 0; i < inorder.length; i++) {
        inMap.put(inorder[i], i);
    }

    Node root = buildpostinHelper(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1, inMap);

    return root;
}

public static Node buildpostinHelper(int[] postorder, int post_start, int post_end, int[] in, int in_start, int in_stop, Map<Integer, Integer> inMap) {
    //here we shall write the ending condition(at the end of the recirsuion stack condition) > 
    if(post_start> post_end || in_start > in_stop) return null;

    Node root = new Node(postorder[post_end]);
    int in_index = inMap.get(root.data);
    int to_left = in_index - in_start;

    root.left = buildpostinHelper(postorder, post_start, post_start + to_left - 1, in, in_start, in_index-1, inMap);
    root.right = buildpostinHelper(postorder, post_start + to_left, post_end - 1, in, in_index+1, in_stop, inMap);
    return root;
}
    
}
