import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.tree.TreeNode;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data1) {
        this.data = data1;
        this.left = null;
        this.right = null;
    }
};

// defining the template for the custom data structure tuple which we shall be
// using for the side view question
class Tuple {
    Node node;
    int row;
    int col;

    public Tuple(Node node1, int row1, int col1) {
        this.node = node1;
        this.row = row1;
        this.col = col1;
    }
}

// defining a class pair 1 so as to view the tree from teh top
class Pair1 {
    Node node;
    int col;

    public Pair1(Node node1, int col1) {
        this.node = node1;
        this.col = col1;
    }
}

// defining a class pair 2 so as to view the tree from teh top
class Pair2 {
    Node node;
    int row;

    public Pair2(Node node1, int row1) {
        this.node = node1;
        this.row = row1;
    }
}

// preorder
public class master {
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // post oprder
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    // inorder
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    // level order
    public static ArrayList<ArrayList<Integer>> levelorder(Node root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            int level_size = q.size();
            ArrayList<Integer> lister = new ArrayList<Integer>();
            for (int i = 0; i < level_size; i++) {
                Node rooter = q.poll();
                lister.add(rooter.data);
                if (rooter.left != null) {
                    q.offer(rooter.left);
                }
                if (rooter.right != null) {
                    q.offer(rooter.right);
                }
            }
            list.add(lister);
        }
        return list;
    }

    // preorder tarversal using iterative method
    // for this, we can use a stack accordingly and keep iusing the LIFO properlty
    // of stacks in the correct order
    public static void preorder_iterative(Node root) {
        // defining the stqack data structure
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node s = stack.pop();
            System.out.println(s.data);
            if (s.right != null) {
                stack.push(s.right);
            }
            if (s.left != null) {
                stack.push(s.left);
            }
        }
    }

    static class Pair<T, U> {
        T first;
        U second;

        // Constructor
        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }

        // Getters
        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }
    }

    public static void preinout(Node root) {
        Stack<Pair<Node, Integer>> st = new Stack<>();
        if (root == null) {
            return;
        }

        ArrayList<ArrayList<Integer>> pre = new ArrayList<>();
        ArrayList<ArrayList<Integer>> in = new ArrayList<>();
        ArrayList<ArrayList<Integer>> post = new ArrayList<>();

        // Push the root node and its state as "preorder" (state is represented by 0 for
        // preorder)
        st.push(new Pair<>(root, 0));

        while (!st.isEmpty()) {
            Pair<Node, Integer> current = st.pop();
            Node node = current.getFirst();
            Integer state = current.getSecond();

            if (state == 0) { // Preorder
                if (node != null) {
                    ArrayList<Integer> preList = new ArrayList<>();
                    preList.add(node.data);
                    pre.add(preList);

                    // Push the node with state "inorder" (state is 1 for inorder)
                    st.push(new Pair<>(node, 1));

                    // Push the right and left children with state "preorder" (state is 0)
                    if (node.right != null)
                        st.push(new Pair<>(node.right, 0));
                    if (node.left != null)
                        st.push(new Pair<>(node.left, 0));
                }
            } else if (state == 1) { // Inorder
                if (node != null) {
                    ArrayList<Integer> inList = new ArrayList<>();
                    inList.add(node.data);
                    in.add(inList);

                    // Push the node with state "postorder" (state is 2 for postorder)
                    st.push(new Pair<>(node, 2));

                    // Push the right child with state "inorder" (state is 1)
                    if (node.right != null)
                        st.push(new Pair<>(node.right, 1));
                }
            } else if (state == 2) { // Postorder
                if (node != null) {
                    ArrayList<Integer> postList = new ArrayList<>();
                    postList.add(node.data);
                    post.add(postList);
                }
            }
        }
    }

    public static int maxheight(Node root) {
        // here we shall use a recursive approach

        if (root == null) {
            return 0;
        }
        int left_height = maxheight(root.left);
        int right_height = maxheight(root.right);

        return 1 + Math.max(left_height, right_height);
    }

    public static int isBalanced(Node root) {
        // basically, a balanced tree is that in which the diff in left and right
        // branches is always less than or equals to 1
        // lets leverage the same max heigh code and use here according
        // we shall try to return -1 is at all it is ot balanced acc to our def of
        // balanced
        if (root == null) {
            return 0;
        }
        int left_height = isBalanced(root.left);
        if (left_height == -1)
            return -1;
        int right_height = isBalanced(root.right);
        if (right_height == -1)
            return -1;
        if (Math.abs(right_height - left_height) > 1) {
            return -1;
        }
        return 1 + Math.max(left_height, right_height);
    }

    // finding max diamter
    static int max = 0;

    public static int diameter(Node root) {
        // here, we have to take the largest distance we can possible get between tow
        // nodes and return it as the diameter
        // so, I have created a global variable that is called Max, we shal leverage
        // that
        if (root == null) {
            return 0;
        }
        int left_height = diameter(root.left);
        int right_height = diameter(root.right);
        max = Math.max(left_height + right_height, max);
        return 1 + Math.max(left_height, right_height);
    }

    public static int getdiameter(Node root) {
        max = 0;
        diameter(root);
        return max;
    }

    // maximum path sum in binary tree
    static int max_sum = 0;

    public static int maxpathsum(Node root) {
        if (root == null) {
            return 0;
        }

        int left_sum = Math.max(0, maxpathsum(root.left)); // ignoring negative paths
        int right_sum = Math.max(0, maxpathsum(root.right));

        max_sum = Math.max(left_sum + right_sum + root.data, max_sum);
        return root.data + Math.max(left_sum, right_sum);

    }

    public static int getmaxpathsum(Node root) {
        max_sum = 0;
        maxpathsum(root);
        return max_sum;
    }

    // similar trees
    public static boolean similartrees(Node root1, Node root2) {
        // using recursion to compare
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean lefter = similartrees(root1.left, root2.left);
        boolean righter = similartrees(root1.right, root2.right);

        return root1.data == root2.data && lefter && righter;
    }

    // zigzag trees
    // bascically here we shall first write our level order traversal and then alter
    // ita ccording to our need. Small tweeking should do
    public static ArrayList<ArrayList<Integer>> zigzag(Node root) {
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

    // top view of a tree
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

    // getting the side view of a tree
    // left view of a tree
    public static ArrayList<Integer> getleftview(Node root) {
        // using the map and queue here. Inmap, we dont need row sie info because add
        // only one element per colum, hence we store only taht in the Queue
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
            if (!map.containsKey(row)) {
                map.put(row, noder);
            }

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

    // checking if the tree is symmertric
    public static boolean isSymmetric(Node root) {
        // here we shall trya nd use a helper function that takes both the sides of the
        // tree and analyses if the tree is symmetric or not
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data) {
            return false;
        }
        boolean lefter = isSymmetricHelper(left.left, right.right);
        boolean middle = isSymmetricHelper(left.right, right.left);
        return lefter && middle;

    }

    // printing from root to nod epath in a tree
    public static ArrayList<Integer> getRootToNode(Node root, int data) {
        ArrayList<Integer> arr = new ArrayList<>();
        getRootToNodeHelper(root, arr, data);
        return arr;
    }

    public static boolean getRootToNodeHelper(Node root, ArrayList<Integer> arr, int data) {
        if (root == null) {
            return false;
        }
        arr.add(root.data);
        if (root.data == data) {
            return true;
        }
        boolean left = getRootToNodeHelper(root.left, arr, data);
        boolean right = getRootToNodeHelper(root.right, arr, data);
        if (left || right) {
        }
        return false;
    }

    // Children sum propertly in trees
    // here we are writing a fundtion to create the tree ina way that the we can
    // increment the value of teh data in teh node
    // we can do that in order to ultimately have the sum of a tree node equal to
    // both of its left and right nodes
    // what we are trying to here is basically have to tackle the issue ot getting
    // laregr lefts and rights because we can only increment

    public static void childrensumproerpty(Node root) {
        if (root == null) {
            return;
        }
        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.data;
        }
        if (root.right != null) {
            sum = sum + root.right.data;
        }
        if (sum > root.data) {
            root.data = sum;
        } else {
            if (root.left != null)
                root.left.data = root.data;
            if (root.right != null)
                root.right.data = root.data;
        }

        childrensumproerpty(root.left);
        childrensumproerpty(root.right);

        int total = 0;
        if (root.left != null) {
            total = total + root.left.data;
        }
        if (root.right != null) {
            total = total + root.right.data;
        }
        if (root.right != null || root.left != null) {
            root.data = total;
        }
        return;
    }

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

    public static ArrayList<Integer> printknodes(Node root, Node ref, int k) {
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

    public static int burntree(Node root, Node ref) {
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

    // creating a tree when we are given post and in order traversals
    public static Node buildpostin(int[] postorder, int[] inorder) {
        // we shall creater a helper fuction to this
        // but, first lets create a map to apropriately get positions in the inorder
        // arary
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        Node root = buildpostinHelper(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);

        return root;
    }

    public static Node buildpostinHelper(int[] postorder, int post_start, int post_end, int[] in, int in_start,
            int in_stop, Map<Integer, Integer> inMap) {
        // here we shall write the ending condition(at the end of the recirsuion stack
        // condition) >
        if (post_start > post_end || in_start > in_stop)
            return null;

        Node root = new Node(postorder[post_end]);
        int in_index = inMap.get(root.data);
        int to_left = in_index - in_start;

        root.left = buildpostinHelper(postorder, post_start, post_start + to_left - 1, in, in_start, in_index - 1,
                inMap);
        root.right = buildpostinHelper(postorder, post_start + to_left, post_end - 1, in, in_index + 1, in_stop, inMap);
        return root;
    }

    // buildinga tree when pre and inorder are given
    public static Node buildprein(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildpreinHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public static Node buildpreinHelper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start,
            int in_end, Map<Integer, Integer> inMap) {
        if (pre_start > pre_end || in_start > in_end)
            return null;

        Node root = new Node(preorder[pre_start]); // root is at the start of preorder
        int in_index = inMap.get(root.data);
        int left_tree_size = in_index - in_start;

        root.left = buildpreinHelper(
                preorder,
                pre_start + 1,
                pre_start + left_tree_size,
                inorder,
                in_start,
                in_index - 1,
                inMap);

        root.right = buildpreinHelper(
                preorder,
                pre_start + left_tree_size + 1,
                pre_end,
                inorder,
                in_index + 1,
                in_end,
                inMap);

        return root;
    }

    // This function searches for a node with
    // a specified value in a Binary Search Tree (BST).
    public Node searchBST(Node root, int val) {
        // Loop until either the tree is
        // exhausted (null) or the value is found.
        while (root != null && root.data != val) {
            // Check if the target value is
            // less than the current node's value.
            // If so, move to the left subtree
            // (values smaller than the current node).
            // Otherwise, move to the right subtree
            // (values larger than the current node).
            root = val < root.data ? root.left : root.right;
        }
        // Return the node containing the target value,
        // if found; otherwise, return null.
        return root;
    }


       public int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = root.data;
                return ceil;
            }
            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }


    public class floorbst {
     public int floorInBST(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = root.data;
                return floor;
            }
            if (key > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
    
}





    public static void main(String[] args) {
        System.out.println("Hi");
    }

}
