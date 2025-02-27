import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int s;
  static int[] arr = new int[20];
  static int result = 0;

  static void func(int k, int sum) {
    if (k == n) {
      if (sum == s) {
        result++;
      }
      return;
    }
    func(k + 1, sum);
    func(k + 1, sum + arr[k]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    s = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    func(0, 0);
    if (s == 0)
      result--;
    System.out.println(result);
  }
}