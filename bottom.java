import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class bottom {
        // getting bottom view of the map. Returning as a list
    public static ArrayList<Integer> getbottonview(Node root) {
        // using a map and a queue and iterating level wise and keeping updating the map
        Map<Integer, Node> map = new TreeMap<>();
        // map -> <column, node associated with column>
        // creatinga queue using the pair1 class we made earlier
        Queue<Pair1> q = new LinkedList<>();
        q.offer(new Pair1(root, 0));
        // the while loop to iterate downwards
        while (!q.isEmpty()) {
            Pair1 pair = q.poll();
            int col = pair.col;
            Node noder = pair.node;

            map.put(col, noder);

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
