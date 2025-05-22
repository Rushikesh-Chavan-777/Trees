
public class kathlargest {
    private void reverseInorder(Node node, int[] counter, int k, int[] kLargest) {
        if (node == null || counter[0] >= k) return;

        // Traverse right subtree
        reverseInorder(node.right, counter, k, kLargest);

        // Increment counter after
        // visiting right subtree
        counter[0]++;

        // Check if current node
        // is the Kth largest
        if (counter[0] == k) {
            kLargest[0] = node.data;
            return;
        }

        // Traverse left subtree if
        // Kth largest is not found yet
        reverseInorder(node.left, counter, k, kLargest);
    }

    private void inorder(Node node, int[] counter, int k, int[] kSmallest) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node, counter, k, kSmallest);

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.data;
            return;
        }

        // Traverse right subtree if
        // Kth smallest is not found yet
        inorder(node.right, counter, k, kSmallest);
    }

    public int[] findKth(Node root, int k) {
        int[] kSmallest = new int[]{Integer.MIN_VALUE};
        int[] kLargest = new int[]{Integer.MIN_VALUE};
        // Counter to track visited nodes
        int[] counter = new int[]{0};

        // Find Kth smallest element
        // (perform inorder traversal)
        inorder(root, counter, k, kSmallest);
        
        // Reset counter for Kth largest element
        counter[0] = 0; 
        // Find Kth largest element
        // (perform reverse inorder traversal)
        reverseInorder(root, counter, k, kLargest);

        return new int[]{kSmallest[0], kLargest[0]};
    }
    
}
