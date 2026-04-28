public class UsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        void addFirst(int data) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }

        void addLast(int data) {
            Node node = new Node(data);
            if (head == null) {
                head = node;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

        boolean remove(int value) {
            if (head == null) {
                return false;
            }
            if (head.data == value) {
                head = head.next;
                return true;
            }
            Node prev = head;
            Node curr = head.next;
            while (curr != null) {
                if (curr.data == value) {
                    prev.next = curr.next;
                    return true;
                }
                prev = curr;
                curr = curr.next;
            }
            return false;
        }

        boolean contains(int value) {
            Node temp = head;
            while (temp != null) {
                if (temp.data == value) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        void reverse() {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }
            head = prev;
        }

        int size() {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }

        void print() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);

        System.out.print("Initial list: ");
        list.print();

        System.out.println("Contains 20? " + list.contains(20));
        System.out.println("Contains 40? " + list.contains(40));

        list.remove(20);
        System.out.print("After removing 20: ");
        list.print();

        list.reverse();
        System.out.print("After reversing: ");
        list.print();

        System.out.println("List size: " + list.size());
    }
}
