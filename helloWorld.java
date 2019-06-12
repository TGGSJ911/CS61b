public class helloWorld {
  public static void windowPosSum(int[] a, int n) {
    for (int i = 0; i < a.length; i++) {
      // System.out.format("The value of i is : %d%n", i);
      int tempSum = 0;
      if (a[i] < 0) {
        continue;
      }
      for (int j = 1; j < n + 1; j++) {
        if (i + j < a.length) {
          System.out.println(j);
          tempSum = tempSum + a[i + j];
        }
      }
      a[i] += tempSum;
    }
  }

  public static void main(String[] args) {
    int[] test = { 1, 2, -3, 4, 5, 4 };
    System.out.print("before ");
    System.out.println(java.util.Arrays.toString(test));
    windowPosSum(test, 3);
    System.out.print("After ");
    System.out.println(java.util.Arrays.toString(test));
  }
}
