// implement linked list in Java
// method: length, ith element, add first, add last, reverse
public class IntNode {
  public int item;
  public IntNode next;

  // build constructor
  public IntNode(int i, IntNode n) {
    this.item = i;
    this.next = n;
  }
}
