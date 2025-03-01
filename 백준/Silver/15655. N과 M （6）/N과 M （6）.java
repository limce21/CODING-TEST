import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();
  static int n;
  static int m;
  static int[] nArr;
  static int[] arr = new int[9];
  static boolean[] isUsed = new boolean[10001];

  static void func(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < n; i++) {
      int val = nArr[i];
      if (!isUsed[val]) {
        if (k == 0) {
          isUsed[val] = true;
          arr[k] = val;
          func(k + 1);
          isUsed[val] = false;
        } else if (val > arr[k - 1]) {
          isUsed[val] = true;
          arr[k] = val;
          func(k + 1);
          isUsed[val] = false;
        }
      }
    }
  }


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    nArr = new int[n];
    for (int i = 0; i < n; i++) {
      nArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(nArr);
    
    func(0);
    System.out.println(sb);
  }
}