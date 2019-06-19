public class Lists1Exercises {
    /**
     * Returns an IntList identical to L, but with each element incremented by x. L
     * is not allowed to change.
     */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        // loop over the list and add the extra x to each
        if (L == null) {
            return null;
        } else {
            L.first += x;
            L.rest = dincrList(L.rest, x);
            return L;
        }
    }

    /**
     * Returns an IntList identical to L, but with each element incremented by x.
     * Not allowed to use the 'new' keyword.
     */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if (L == null) {
            return null;
        } else {
            L.first -= x;
            L.rest = dincrList(L.rest, x);
            return L;
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);
        IntList A;
        A = dincrList(L, 2);
        System.out.println(A.get(1));
        System.out.println(A.get(2));
        System.out.println(A.get(3));
    }
}