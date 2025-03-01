import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  static int n;
  static int m;
  static int[] arr = new int[9];

  static void func(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (k == 0) {
        arr[k] = i;
        func(k + 1);
      } else if (i >= arr[k - 1]) {
        arr[k] = i;
        func(k + 1);
      }
    }
  }


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    func(0);
    System.out.println(sb);
  }
}