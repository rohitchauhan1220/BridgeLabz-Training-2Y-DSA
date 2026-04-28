public class ArrayClassLevelGenerics {
    static class Stack<T> {
        private int top;
        private int size;
        private T[] stack;

        @SuppressWarnings("unchecked")
        public Stack(int size) {
            this.size = size;
            this.stack = (T[]) new Object[size];
            this.top = -1;
        }

        public void push(T x) {
            if (top == size - 1) {
                System.out.println("Stack Overflow");
            } else {
                top++;
                stack[top] = x;
            }
        }

        public T pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return null;
            } else {
                T value = stack[top];
                top--;
                return value;
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is Empty");
            } else {
                System.out.print("Stack elements: ");
                for (int i = top; i >= 0; i--) {
                    System.out.print(stack[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        Stack<Integer> st1 = new Stack<>(5);
        st1.push(10);
        st1.push(20);
        st1.push(30);
        st1.display();

        Stack<Character> st2 = new Stack<>(5);
        st2.push('A');
        st2.push('B');
        st2.push('C');
        st2.display();
    }
}

