import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class burntree {
    public static void getparents(Node root, Map<Node, Node> mapper) {
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        Node noder = q.poll();
        if (noder.left != null) {
            q.offer(noder.left);
            mapper.put(noder.left, noder);
        }
        if (noder.right != null) {
            q.offer(noder.right);
            mapper.put(noder.right, noder);
        }
    }
}
    public static int burntree1(Node root, Node ref) {
    Map<Node, Node> parent_map = new HashMap<>();
    getparents(root, parent_map);

    Map<Node, Boolean> visited = new HashMap<>();
    Queue<Node> q = new LinkedList<>();

    q.offer(ref);
    visited.put(ref, true);

    int time = 0;

    while (!q.isEmpty()) {
        int size = q.size();
        boolean anyNewFire = false;

        for (int i = 0; i < size; i++) {
            Node curr = q.poll();

            // Spread to left child
            if (curr.left != null && !visited.containsKey(curr.left)) {
                visited.put(curr.left, true);
                q.offer(curr.left);
                anyNewFire = true;
            }

            // Spread to right child
            if (curr.right != null && !visited.containsKey(curr.right)) {
                visited.put(curr.right, true);
                q.offer(curr.right);
                anyNewFire = true;
            }

            // Spread to parent
            Node parent = parent_map.get(curr);
            if (parent != null && !visited.containsKey(parent)) {
                visited.put(parent, true);
                q.offer(parent);
                anyNewFire = true;
            }
        }

        if (anyNewFire) {
            time++; // only increment time if fire spread in this round
        }
    }
  
    return time;
}
    
}
