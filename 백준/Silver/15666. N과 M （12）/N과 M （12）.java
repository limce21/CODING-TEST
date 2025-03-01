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

  static void func(int k) {
    if (k == m) {
      for (int i = 0; i < m; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }
    int tmp = 0;
    for (int i = 0; i < n; i++) {
      if (tmp != nArr[i]) {
        if (k == 0) {
          arr[k] = nArr[i];
          tmp = nArr[i];
          func(k + 1);          
        } else if (nArr[i] >= arr[k - 1]) {
          arr[k] = nArr[i];
          tmp = nArr[i];
          func(k + 1);
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