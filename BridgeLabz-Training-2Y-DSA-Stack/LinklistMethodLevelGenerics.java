public class LinklistMethodLevelGenerics {

    static class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    // PUSH (Method level generic)
    public static <T> void push(T value) {
        Node newNode = new Node(value);

        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // POP (Method level generic)
    public static <T> T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        }

        T value = (T) top.data;
        top = top.next;
        return value;
    }

    public static boolean isEmpty() {
        return top == null;
    }

    public static void display() {
        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        push(10);
        push(20);
        push(30);

        display();

        System.out.println("Popped: " + pop());
        display();

        push("Hello");
        push("World");

        display();
    }
}
