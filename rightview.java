import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class rightview {
        // right view of a tree
    public static ArrayList<Integer> getrightview(Node root) {
        Map<Integer, Node> map = new TreeMap<>();
        // creating the queue
        Queue<Pair2> q = new LinkedList<>();
        // offering the root to the queue
        q.offer(new Pair2(root, 0));
        // finally the while loop to iterate downwarddsa ansd add only teh top
        while (!q.isEmpty()) {
            Pair2 par = q.poll();
            Node noder = par.node;
            int row = par.row;
            map.put(row, noder);

            if (noder.left != null) {
                q.offer(new Pair2(noder.left, row + 1));
            }
            if (noder.right != null) {
                q.offer(new Pair2(noder.right, row + 1));
            }
        }
        ArrayList<Integer> llist = new ArrayList<>();
        for (Map.Entry<Integer, Node> mapper : map.entrySet()) {
            llist.add(mapper.getValue().data);
        }
        return llist;
    }
    
}
