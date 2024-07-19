package algorithm.sec14_search_traverse;

public class ValidateBSTInOrderTraversalAdvanced {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    // The item on the left in the in-order traversal array.
    private TreeNode previous;

    /**
     * This function still use in-order traversal array. But it is faster and takes
     * less memory. Instead of coverting tree ndoes to in-order traversal array, it
     * only keeps previous node, aka the item on the left.
     * 
     * This function first validates if the left branch of the current node. When
     * doing this, the left item to the current node is set to the variable
     * previous. Then it check if the previous node is less than the current node.
     * If still valid, it set varaible previous to the current node (aka the current
     * node is the left time to the right branch). Finally, it validates the right
     * branch of the current node.
     */
    public boolean isValidBST(TreeNode node) {
        boolean valid = true;

        // Validate left branch and set left item to the current node.
        if (node.left != null) {
            valid = isValidBST(node.left);
            // If left tree isn't valid, exit the process.
            if (!valid)
                return false;
        }

        // Validate the current node by comparing it with the item on its left.
        if (previous != null && previous.val >= node.val)
            return false;
        previous = node; // Current node becomes the left item to its right branch.

        // Validate the right branch
        if (node.right != null)
            return isValidBST(node.right);
        else
            return true;
    }

}
