package datastructure.sec8_linkedlist;

public class SinglyLinkedList {

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s[value=%d, next=%s]", getString(), value, next == null ? null : next.getString());
        }

        private String getString() {
            return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(int value) {
        head = new Node(value);
        tail = head;
        size = 1;
    }

    public void append(int value) {
        if (tail == null) {
            head = tail = new Node(value);
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
        }
        size++;
        print();
    }

    public void prepend(int value) {
        if (head == null) {
            head = tail = new Node(value);
        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
        size++;
        print();
    }

    public void insert(int index, int value) {
        validateIndex(index);
        if (index == 0) {
            prepend(value);
        } else {
            Node prev = nodeAt(index - 1);
            Node next = prev.next;
            Node node = new Node(value);
            node.next = next;
            prev.next = node;
            size++;
            print();
        }
    }

    public int remove(int index) {
        validateIndex(index);
        Node toDelete = null;
        if (index == 0) {
            toDelete = head;
            head = head.next;
        } else {
            Node prev = nodeAt(index - 1);
            toDelete = nodeAt(index);
            prev.next = toDelete.next;
        }
        size--;
        print();
        return toDelete.value;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%d, index=%d", size, index));
        }
    }

    public void reverse() {
        if (size <= 1) {
            print();
            return;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
        print();
    }

    public Node nodeAt(int index) {
        validateIndex(index);
        if (index == 0) {
            return head;
        }
        if (index == size - 1) {
            return tail;
        }
        Node node = head;
        int i = 0;
        while (i++ < index) {
            node = node.next;
        }
        return node;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void print() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName() + ": size=" + size + ", data=[");
        Node node = head;
        while (node != null) {
            sb.append(node.value).append(", ");
            node = node.next;
        }
        sb.delete(sb.length() - 2, sb.length()).append("]");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName() + ": size=" + size + ", data=[");
        Node node = head;
        while (node != null) {
            sb.append(node.toString()).append(",");
            node = node.next;
        }
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList(5);
        list.append(10);
        list.append(15);
        System.out.println("Size: " + list.getSize());
        System.out.println("Head: " + list.getHead());
        System.out.println("Tail: " + list.getTail());
        list.prepend(0);
        list.insert(0, -1);
        list.insert(2, -1);
        list.insert(5, -1);

        try {
            list.insert(list.getSize(), -2);
        } catch (Exception e) {
            e.printStackTrace();
            list.print();
        }

        list.remove(0);
        list.remove(1);
        list.remove(list.getSize() - 1);

        list.reverse();
    }

}
