import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[] arr;
  static int[] operator = new int[4];
  static int maxResult = Integer.MIN_VALUE;
  static int minResult = Integer.MAX_VALUE;

  static void search(int k, int value) {
    if (k == n) {
      maxResult = Math.max(maxResult, value);
      minResult = Math.min(minResult, value);
      return;
    }
    if (operator[0] > 0) {
      operator[0] -= 1;
      search(k + 1, value + arr[k]);
      operator[0] += 1;
    }
    if (operator[1] > 0) {
      operator[1] -= 1;
      search(k + 1, value - arr[k]);
      operator[1] += 1;
    }
    if (operator[2] > 0) {
      operator[2] -= 1;
      search(k + 1, value * arr[k]);
      operator[2] += 1;
    }
    if (operator[3] > 0) {
      operator[3] -= 1;
      search(k + 1, value / arr[k]);
      operator[3] += 1;
    }
    
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      operator[i] = Integer.parseInt(st.nextToken());
    }
    search(1, arr[0]);
    System.out.println(maxResult);
    System.out.println(minResult);
  }
}

