import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class vertical {
        // vertical view of trees
    public static ArrayList<ArrayList<Integer>> vertical_view(Node root) {
        // here, we shallbasically try to use two things. One is a Queue and even a Map.
        // A tittle more of a complex queue that takes in three things, which I have
        // definied at the very top as a tuple, so I will use that here from the tuple
        // class
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // creating the queue on its own
        Queue<Tuple> q = new LinkedList<Tuple>();
        // offering the first node and its coordinates to the queue
        q.offer(new Tuple(root, 0, 0));
        // now, finally creating the while oop
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            Node noder = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            // now, checking and adding to the map accordingly
            if (!map.containsKey(row)) {
                map.put(row, new TreeMap<>());
            }
            if (!map.get(row).containsKey(col)) {
                map.get(row).put(col, new PriorityQueue<>());
            }
            map.get(row).get(col).offer(noder.data);

            if (noder.left != null) {
                q.offer(new Tuple(noder.left, row - 1, col + 1));
            }
            if (noder.right != null) {
                q.offer(new Tuple(noder.right, row + 1, col + 1));
            }
        }

        ArrayList<ArrayList<Integer>> llist = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> mapper : map.values()) {
            llist.add(new ArrayList<Integer>());
            for (PriorityQueue<Integer> pq : mapper.values()) {
                while (!pq.isEmpty()) {
                    System.out.println(pq.peek());
                    llist.get(llist.size() - 1).add(pq.poll());
                }
            }
        }
        return llist;
    }
    
}
