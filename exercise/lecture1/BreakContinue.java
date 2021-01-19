public class BreakContinue {
    public static void windowPosSum(int[] a, int n) {
        /** your code here */        
        for (int i = 0; i < a.length - 1; i++) {
            int sum = 0;
            if (a[i] > 0) {
                for (int j = 0; j < n+1; j++) {
                    if (i + j < a.length) {
                        sum = sum + a[i + j];
                    } else
                    {
                        continue;
                    }
                }
            a[i] = sum;
            }
        }
    }
  
    public static void main(String[] args) {
      int[] a = {1, 2, -3, 4, 5, 4};
      int n = 3;
      windowPosSum(a, n);
  
      // Should print 4, 8, -3, 13, 9, 4
      System.out.println(java.util.Arrays.toString(a));
    }
  }