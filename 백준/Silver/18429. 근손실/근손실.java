import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int k;
  static int[] a;
  static int result = 0;
  static boolean isUsed[];

  static void search(int c, int w) {
    if (c == n) {
      result++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if (!isUsed[i] && w + a[i] - k >= 500) {
        isUsed[i] = true;
        search(c + 1, w + a[i] - k);
        isUsed[i] = false;
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    a = new int[n];
    isUsed = new boolean[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    search(0, 500);
    System.out.println(result);
  }
}
