import java.util.Stack;

public class ReverseStack {
    private static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        
        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, top);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        
        System.out.println("Original stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed stack: " + stack);
    }
}
