import java.util.Stack;

class MyQueue {
    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (!stack1.isEmpty() && stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return (int) stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }

}