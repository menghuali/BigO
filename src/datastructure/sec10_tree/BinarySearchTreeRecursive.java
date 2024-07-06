package datastructure.sec10_tree;

public class BinarySearchTreeRecursive {

    private Node root;

    public void insert(int value) {
        Node toInsert = new Node(value);
        if (root == null) {
            root = toInsert;
        } else {
            insert(toInsert, root);
        }
    }

    private void insert(Node toInsert, Node node) {
        if (toInsert.getValue() == node.getValue()) {
            return; // Do nothing of node with same value is already in the tree
        } else if (toInsert.getValue() < node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(toInsert);
            } else {
                insert(toInsert, node.getLeft());
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(toInsert);
            } else {
                insert(toInsert, node.getRight());
            }
        }
    }

    public Node lookup(int value) {
        Node node = lookup(value, root);
        System.out.println(node);
        return node;
    }

    public void remove(int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    private Node lookup(int value, Node node) {
        if (value == node.getValue()) {
            return node;
        } else {
            node = value < node.getValue() ? node.getLeft() : node.getRight();
            return node == null ? null : lookup(value, node);
        }
    }
    
    public void print() {
        System.out.println(root);
    }

    public static void main(String[] args) {
        BinarySearchTreeRecursive bst = new BinarySearchTreeRecursive();
        bst.insert(9);
        bst.insert(4);
        bst.insert(20);
        bst.insert(1);
        bst.insert(6);
        bst.insert(15);
        bst.insert(170);
        bst.print();

        bst.lookup(20);
        bst.lookup(1);
        bst.lookup(15);
        bst.lookup(100);
    }

}
