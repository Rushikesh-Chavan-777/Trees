import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class levelorder {
    public static ArrayList<ArrayList<Integer>> levelorder1(Node root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level_size = q.size();
            ArrayList<Integer> lister = new ArrayList<Integer>();
            for(int i = 0; i < level_size; i++) {
                Node rooter = q.poll();
                lister.add(rooter.data);
                if(rooter.left != null) {
                    q.offer(rooter.left);
                }
                if(rooter.right != null){
                    q.offer(rooter.right);
                }
            }
            list.add(lister);
        }
        return list;
    }
    
}
