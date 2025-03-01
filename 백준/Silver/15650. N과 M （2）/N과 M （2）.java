import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[] arr = new int[9];
  static boolean[] isUsed = new boolean[9];

  static void func(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (!isUsed[i]) {
        if (k == 0) {
          isUsed[i] = true;
          arr[k] = i;
          func(k + 1);
          isUsed[i] = false;
        } else if (i > arr[k - 1]) {
          isUsed[i] = true;
          arr[k] = i;
          func(k + 1);
          isUsed[i] = false;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    func(0);
  }
}


