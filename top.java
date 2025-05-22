import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class top {
        public static ArrayList<Integer> gettopview(Node root) {
        // using the map and queue here. Inmap, we dont need row sie info because add
        // only one element per colum, hence we store only taht in the Queue
        Map<Integer, Node> map = new TreeMap<>();
        // creating the queue
        Queue<Pair1> q = new LinkedList<>();
        // offering the root to the queue
        q.offer(new Pair1(root, 0));
        // finally the while loop to iterate downwarddsa ansd add only teh top
        while (!q.isEmpty()) {
            Pair1 par = q.poll();
            Node noder = par.node;
            int col = par.col;
            if (!map.containsKey(col)) {
                map.put(col, noder);
            }

            if (noder.left != null) {
                q.offer(new Pair1(noder.left, col - 1));
            }
            if (noder.right != null) {
                q.offer(new Pair1(noder.right, col + 1));
            }
        }
        ArrayList<Integer> llist = new ArrayList<>();
        for (Map.Entry<Integer, Node> mapper : map.entrySet()) {
            llist.add(mapper.getValue().data);
        }
        return llist;
    }
    
}
