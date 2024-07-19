package algorithm.sec14_search_traverse;

import java.util.LinkedList;
import java.util.List;

public class ValidateBSTInOrderTraversal {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    /**
     * This method first convert the tree nodes to an in-order traversal array of
     * numbers. Then it iteratate the in-order traversal array. The items on the
     * left must be less than the item on the right. If it's violated, the BST is
     * invalid; otherwise, the BST is valid.
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrderTraverse(root, list);
        int[] numbers = list.stream().mapToInt(i -> i).toArray();

        for (int i = 1; i < numbers.length; i++)
            if (numbers[i - 1] > numbers[i])
                return false;

        return true;
    }

    private void inOrderTraverse(TreeNode node, List<Integer> list) {
        if (node.left != null)
            inOrderTraverse(node.left, list);
        list.add(node.val);
        if (node.right != null)
            inOrderTraverse(node.right, list);
    }

}
