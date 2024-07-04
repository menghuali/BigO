package datastructure.sec9_queue_stack;

public class MyLinkedListStack {

    private Node top;
    private int length;

    public MyLinkedListStack() {
        top = null;
    }

    public String peek() {
        return top == null ? null : top.getValue();
    }

    public void push(String value) {
        Node node = new Node(value, top);
        top = node;
        length++;
    }

    public String pop() {
        if (top == null) {
            return null;
        } else {
            String value = top.getValue();
            top = top.getNext();
            length--;
            return value;
        }
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        MyLinkedListStack stack = new MyLinkedListStack();
        System.out.println(stack.getLength());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.getLength());

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getLength());

        System.out.println(stack.pop());
        System.out.println(stack.getLength());
        System.out.println(stack.pop());
        System.out.println(stack.getLength());
    }

}
