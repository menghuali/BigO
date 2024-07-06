package datastructure.sec10_tree;

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
     */
    public void remove(int value) {
        Node[] toRemoveAndParent = lookupNodeAndParent(value);
        Node toRemove = toRemoveAndParent[0];
        Node parentOfToRemvoe = toRemoveAndParent[1];
        if (toRemove == null)
            return;
        if (toRemove.getRight() != null) {
            Node[] minAndParent = findMinAndParent(toRemove.getRight());
            Node min = minAndParent[0];
            Node parentOfMin = minAndParent[1];
            if (parentOfMin == null) {
                toRemove.setRight(min.getRight());
            } else {
                parentOfMin.setLeft(min.getRight());
            }
            toRemove.setValue(min.getValue());
        } else {
            if (parentOfToRemvoe == null) {
                root = root.getLeft();
            } else {
                if (parentOfToRemvoe.getLeft() == toRemove) {
                    parentOfToRemvoe.setLeft(toRemove.getLeft());
                } else {
                    parentOfToRemvoe.setRight(toRemove.getLeft());
                }
            }
        }
        print();
    }

    private Node[] lookupNodeAndParent(int value) {
        Node found = null;
        Node parent = null;
        Node current = root;
        while (current != null) {
            if (value == current.getValue()) {
                found = current;
                break;
            } else if (value < current.getValue()) {
                parent = current;
                current = current.getLeft();
            } else {
                parent = current;
                current = current.getRight();
            }
        }
        return new Node[] { found, parent };
    }

    private Node[] findMinAndParent(Node node) {
        Node min = node;
        Node parent = null;
        while (min.getLeft() != null) {
            parent = min;
            min = min.getLeft();
        }
        return new Node[] { min, parent };
    }

    public void print() {
        System.out.println(root);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(6);
        bst.insert(15);
        bst.insert(170);
        // bst.print();

        bst.remove(20);
    }
}
