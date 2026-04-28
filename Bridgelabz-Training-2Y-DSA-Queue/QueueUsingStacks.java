import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStacks {
    private Deque<Integer> stack1 = new ArrayDeque<>();
    private Deque<Integer> stack2 = new ArrayDeque<>();

    public void enqueue(int x) {
        stack1.push(x);
        System.out.println("Added: " + x);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());

        q.enqueue(40);
        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
        System.out.println("Removed: " + q.dequeue());
    }
}
