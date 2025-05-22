import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class printknodes {

        public static ArrayList<Integer> printknodes1(Node root, Node ref, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Node, Node> parent_map = new HashMap<>();
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        visited.put(ref, true);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (count == k) {
                break;
            }
            count++;
            for (int i = 0; i < size; i++) {
                Node noder = q.poll();
                if (noder.left != null && visited.get(noder.left) == null) {
                    q.offer(noder.left);
                    visited.put(noder.left, true);
                }
                if (noder.right != null && visited.get(noder.right) == null) {
                    q.offer(noder.right);
                    visited.put(noder.right, true);
                }
                if (parent_map.get(noder) != null && visited.get(parent_map.get(noder)) == null) {
                    q.offer(parent_map.get(noder));
                    visited.put(parent_map.get(noder), true);
                }
            }
        }
        while (!q.isEmpty()) {
            ans.add(q.poll().data);
        }
        return ans;
    }
}
