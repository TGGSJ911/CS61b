public class SLList {
    public IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    // add an element ahead of the list
    public void addFrist(int x) {
        first = new IntNode(x, first);
    }

    public void addLast(int x) {
        IntNode p = first;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);

    }

    public int getFirst() {
        // general case
        return first.item;
    }

    // helper function for size
    private static int size_recursion(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + size_recursion(p.next);

    }

    public int size() {
        // int size = 0;
        // IntNode p = first;
        // while (p != null) {
        // p = p.next;
        // size += 1;
        // }
        // return size;
        return size_recursion(first);
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addLast(20);
        int result = L.size();
        System.out.println(result);
    }
}