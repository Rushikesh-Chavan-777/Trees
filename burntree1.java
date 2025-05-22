import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class burntree1 {
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
    
}
