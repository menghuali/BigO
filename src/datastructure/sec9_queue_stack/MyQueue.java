package datastructure.sec9_queue_stack;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> enqueue;
    private Stack<Integer> dequeue;

    public MyQueue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }

    public void push(int x) {
        enqueue.push(x);
    }

    public int pop() {
        if (dequeue.isEmpty()) {
            enqueueToDequeue();
        }
        return dequeue.pop();
    }

    private void enqueueToDequeue() {
        while (!enqueue.isEmpty()) {
            dequeue.push(enqueue.pop());
        }
    }

    public int peek() {
        if (dequeue.isEmpty()) {
            enqueueToDequeue();
        }
        return dequeue.peek();
    }

    public boolean empty() {
        return enqueue.isEmpty() && dequeue.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println(queue.empty());
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.empty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        queue.push(6);
        System.out.println(queue.pop());
        queue.push(7);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
