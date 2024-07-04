package datastructure.sec9_queue_stack;

public class MyArrayStack {

    private int top;
    private String[] array;

    public MyArrayStack(int maxLen) {
        array = new String[maxLen];
        top = -1;
    }

    public String peek() {
        return top == -1 ? null : array[top];
    }

    public void push(String value) {
        if (top + 1 == array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array[++top] = value;
    }

    public String pop() {
        return top == -1 ? null : array[top--];
    }

    public int getLength() {
        return top + 1;
    }

    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(5);
        System.out.println(stack.getLength());
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        System.out.println(stack.getLength());
        try {
            stack.push("F");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(stack.getLength());
        }

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getLength());

        System.out.println(stack.pop());
        System.out.println(stack.getLength());
        System.out.println(stack.pop());
        System.out.println(stack.getLength());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.getLength());
    }

}
