import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class parentmap {
        // printing all nodes at a distance k froma a given no0de
    // basically, I will try to leverage A BFS approach here, and my Breadth is not
    // only restricted to left and right but to parent as well
    // so we shall aid the code witha map that adds the parent node to teh current
    // node
    // lets start with taht now
    public static void parentmapper(Node root, Map<Node, Node> parrent_map) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node noder = q.poll();
            if (noder.left != null) {
                parrent_map.put(noder.left, noder);
                q.offer(noder.left);
            }
            if (noder.right != null) {
                parrent_map.put(noder.right, noder);
                q.offer(noder.right);
            }
        }
    }
    
}
