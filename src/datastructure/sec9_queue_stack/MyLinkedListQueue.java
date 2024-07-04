package datastructure.sec9_queue_stack;

public class MyLinkedListQueue {

    private Node first;
    private Node last;
    private int length;

    public String peek() {
        return first == null ? null : first.getValue();
    }

    public void enqueue(String value) {
        if (first == null) {
            first = new Node(value, null);
            last = first;
        } else {
            Node node = new Node(value);
            last.setNext(node);
            last = node;
        }
        length++;
    }

    public String dequeue() {
        String value = null;
        if (first != null) {
            value = first.getValue();
            first = first.getNext();
            length--;
            if (length == 0) {
                last = null;
            }
        }
        return value;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        System.out.println(queue.getLength());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue.getLength());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getLength());

        System.out.println(queue.dequeue());
        System.out.println(queue.getLength());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getLength());

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        System.out.println(queue.getLength());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getLength());

        System.out.println(queue.dequeue());
        System.out.println(queue.getLength());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.getLength());
    }

}
