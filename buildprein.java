import java.util.HashMap;
import java.util.Map;

public class buildprein {

    // buildinga  tree when pre and inorder are given 
public static Node buildprein1(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
        inMap.put(inorder[i], i);
    }

    return buildpreinHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
}

public static Node buildpreinHelper(int[] preorder, int pre_start, int pre_end,int[] inorder, int in_start, int in_end,Map<Integer, Integer> inMap) {
    if (pre_start > pre_end || in_start > in_end) return null;

    Node root = new Node(preorder[pre_start]);  // root is at the start of preorder
    int in_index = inMap.get(root.data);
    int left_tree_size = in_index - in_start;

    root.left = buildpreinHelper(
        preorder,
        pre_start + 1,
        pre_start + left_tree_size,
        inorder,
        in_start,
        in_index - 1,
        inMap
    );

    root.right = buildpreinHelper(
        preorder,
        pre_start + left_tree_size + 1,
        pre_end,
        inorder,
        in_index + 1,
        in_end,
        inMap
    );

    return root;
}
    
}
