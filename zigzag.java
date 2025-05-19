import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class zigzag {

    // zigzag trees
    // bascically here we shall first write our level order traversal and then alter
    // ita ccording to our need. Small tweeking should do
    public static ArrayList<ArrayList<Integer>> zigzag1(Node root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> q = new LinkedList<Node>();
        boolean lefttoright = true;
        q.offer(root);
        while (!q.isEmpty()) {
            int level_size = q.size();
            ArrayList<Integer> sub_list = new ArrayList<Integer>();
            for (int i = 0; i < level_size; i++) {
                Node rooter = q.poll();
                // sub_list.add(rooter.data);
                if (lefttoright)
                    sub_list.add(rooter.data);
                else {
                    sub_list.add(0, rooter.data);
                }

                if (rooter.left != null) {
                    q.add(rooter.left);
                }
                if (rooter.right != null) {
                    q.add(rooter.right);
                }
            }
            lefttoright = !lefttoright;
            list.add(sub_list);
        }
        return list;
    }
    
}
