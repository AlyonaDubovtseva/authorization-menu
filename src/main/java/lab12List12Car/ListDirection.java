package lab12List12Car;

public class ListDirection {
    private Node first;

    public void add(Car value) {
        if (first == null) {
            first = new Node(value);
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
            current.next.prev = current;
        }
    }

    public boolean addOnPosition(int position, Car value) {
        if (position < 0) {
            return false;
        }

        Node newNode = new Node(value);

        if (position == 0) {
            if (first != null) {
                newNode.next = first;
                first.prev = newNode;
            }
            first = newNode;
            return true;
        }

        Node current = first;
        for (int i = 0; i < position - 1; ++i) {
            if (current == null) {
                return false;
            }
            current = current.next;
        }

        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        newNode.prev = current;
        current.next = newNode;

        return true;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public void sort() {
        if (first == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = first;

            while (current.next != null) {
                if (current.value.compare(current.next.value) > 0) {
                    Car temp = current.value;
                    current.value = current.next.value;
                    current.next.value = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }
}

