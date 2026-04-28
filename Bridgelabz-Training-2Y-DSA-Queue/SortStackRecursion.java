import java.util.ArrayDeque;
import java.util.Deque;

public class SortStackRecursion {

    public static void sort(Deque<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        sort(stack);
        place(stack, top);
    }

    private static void place(Deque<Integer> stack, int val) {
        if (stack.isEmpty() || val > stack.peek()) {
            stack.push(val);
            return;
        }

        int temp = stack.pop();
        place(stack, val);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(30);
        stack.push(-5);
        stack.push(18);
        stack.push(14);
        stack.push(-3);

        System.out.println("Stack: " + stack);
        sort(stack);
        System.out.println("Sorted: " + stack);
    }
}
