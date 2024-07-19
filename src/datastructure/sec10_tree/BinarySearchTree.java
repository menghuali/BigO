package datastructure.sec10_tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.function.Supplier;

public class BinarySearchTree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            Node current = root;
            while (true) {
                if (value == current.getValue()) {
                    return;
                } else if (value < current.getValue()) {
                    if (current.getLeft() == null) {
                        current.setLeft(new Node(value));
                        return;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(new Node(value));
                        return;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }

    public Node lookup(int value) {
        Node found = null;
        Node current = root;
        while (current != null) {
            if (value == current.getValue()) {
                found = current;
                break;
            } else if (value < current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        System.out.println(found);
        return found;
    }

    /**
     * 1. Find the node to remove
     * 2. If the node to remove has right child, find the min from right branch.
     * 2.1 If the min has right child, replace min with right child (value, left,
     * right)
     * 2.2 Replace the node to remove with the min node
     * 3. If the node to remove has no right child, replace it with the left child
     * 
     * Sample tree:
     */
    public void remove(int value) {
        // 1. If root is empty, exit method.
        if (root == null)
            return;
        // 2. Find the node to remove and the parent node.
        Node currentNode = root;
        Node parent = null;
        while (currentNode != null) {
            if (value < currentNode.getValue()) {
                parent = currentNode;
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue()) {
                parent = currentNode;
                currentNode = currentNode.getRight();
            } else {
                remvoeNode(currentNode, parent);
                break;
            }
        }

        print();
    }

    private void remvoeNode(Node toRemove, Node parent) {
        if (toRemove.getLeft() == null && toRemove.getRight() == null) {
            // 1. Leaf node
            replaceWith(toRemove, null, parent);
        } else if (toRemove.getRight() == null) {
            // 2. If node to remove only has left child
            replaceWith(toRemove, toRemove.getLeft(), parent);
        } else if (toRemove.getRight() != null) {
            // 3. If node to remove has right child
            Node child = toRemove.getRight();
            if (child.getLeft() == null) {
                // 3.1 If right child node doesn't have left child node
                replaceWith(toRemove, child, parent);
            } else {
                // 3.2 If right child node has left child node
                replaceWithMinRightChild(toRemove, parent);
            }
        }
    }

    private void replaceWithMinRightChild(Node toBeReplaced, Node parent) {
        Node parentOfMin = toBeReplaced.getRight();
        Node min = parentOfMin.getLeft();
        // Find the min node from the right brach of the node to be replaced
        while (min.getLeft() != null) {
            parentOfMin = min;
            min = min.getLeft();
        }
        // Replace the left child of min-parent with the right child of min
        replaceWith(min, min.getRight(), parentOfMin);

        // Set child nodes of min to those of the to-be-placed node
        min.setLeft(toBeReplaced.getLeft());
        min.setRight(toBeReplaced.getRight());
        // Replace with min node
        replaceWith(toBeReplaced, min, parent);
    }

    private void replaceWith(Node toBeReplaced, Node replacement, Node parent) {
        if (parent == null) {
            root = replacement;
        } else {
            if (toBeReplaced == parent.getLeft()) {
                parent.setLeft(replacement);
            } else {
                parent.setRight(replacement);
            }
        }
    }

    public void print() {
        System.out.println(root);
    }

    public Node BFS(int value) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node node;
        while ((node = queue.poll()) != null) {
            if (node.getValue() == value) {
                return node;
            } else {
                if (node.getLeft() != null)
                    queue.add(node.getLeft());
                if (node.getRight() != null)
                    queue.add(node.getRight());
            }
        }
        return null;
    }

    public Node recursiveBFS(int value) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        return recursiveBFS(value, queue);
    }

    private Node recursiveBFS(int value, Queue<Node> queue) {
        Node node = queue.poll();
        if (node == null)
            return null;

        if (node.getValue() == value)
            return node;

        if (node.getLeft() != null)
            queue.add(node.getLeft());
        if (node.getRight() != null)
            queue.add(node.getRight());
        return recursiveBFS(value, queue);
    }
    // 9
    // 4 20
    // 1 6 15 170
    // 1, 4, 6, 9, 15, 20, 170

    public int[] inOrderTraverse() {
        List<Integer> list = new LinkedList<>();
        inOrderTraverse(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void inOrderTraverse(Node node, List<Integer> list) {
        if (node.getLeft() != null)
            inOrderTraverse(node.getLeft(), list);
        list.add(node.getValue());
        if (node.getRight() != null)
            inOrderTraverse(node.getRight(), list);
    }

    public int[] preOrderTraverse() {
        List<Integer> list = new LinkedList<>();
        preOrderTraverse(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void preOrderTraverse(Node node, List<Integer> list) {
        list.add(node.getValue());
        if (node.getLeft() != null)
            preOrderTraverse(node.getLeft(), list);
        if (node.getRight() != null)
            preOrderTraverse(node.getRight(), list);
    }

    public int[] postOrderTraverse() {
        List<Integer> list = new LinkedList<>();
        postOrderTraverse(root, list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void postOrderTraverse(Node node, List<Integer> list) {
        if (node.getLeft() != null)
            postOrderTraverse(node.getLeft(), list);
        if (node.getRight() != null)
            postOrderTraverse(node.getRight(), list);
        list.add(node.getValue());
    }

    public int[] levelOrderTraverse() {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        queue.add(root);
        Node node;
        while ((node = queue.poll()) != null) {
            list.add(node.getValue());
            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public Node search(Function<Integer, Node> function, int value) {
        Node node = function.apply(value);
        System.out.println(node);
        return node;
    }

    public int[] traverse(Supplier<int[]> supplier) {
        int[] array = supplier.get();
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(", ");
        }
        System.out.println(sb.toString());
        return array;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = buildTree();
        bst.traverse(bst::inOrderTraverse);
        bst.traverse(bst::preOrderTraverse);
        bst.traverse(bst::postOrderTraverse);
        bst.traverse(bst::levelOrderTraverse);
    }

    private static BinarySearchTree buildTree() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(6);
        bst.insert(15);
        bst.insert(170);
        return bst;
    }
}
