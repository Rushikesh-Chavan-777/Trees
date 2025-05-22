public class childrensumproperty {

       // Children sum propertly in trees
    // here we are writing a fundtion to create the tree ina way that the we can
    // increment the value of teh data in teh node
    // we can do that in order to ultimately have the sum of a tree node equal to
    // both of its left and right nodes
    // what we are trying to here is basically have to tackle the issue ot getting
    // laregr lefts and rights because we can only increment

    public static void childrensumproerpty(Node root) {
        if (root == null) {
            return;
        }
        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.data;
        }
        if (root.right != null) {
            sum = sum + root.right.data;
        }
        if (sum > root.data) {
            root.data = sum;
        } else {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }

        childrensumproerpty(root.left);
        childrensumproerpty(root.right);

        int total = 0;
        if (root.left != null) {
            total = total + root.left.data;
        }
        if (root.right != null) {
            total = total + root.right.data;
        }
        if (root.right != null || root.left != null) {
            root.data = total;
        }
        return;
    }
    
}
