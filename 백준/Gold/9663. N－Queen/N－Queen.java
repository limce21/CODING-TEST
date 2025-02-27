import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int result = 0;
  static boolean[] isUsed1 = new boolean[40];
  static boolean[] isUsed2 = new boolean[40];
  static boolean[] isUsed3 = new boolean[40];

  static void func(int k) {
    if (k == n) {
      result++;
      return;
    }
    for (int i = 0; i < n; i++) {
      if(isUsed1[i] || isUsed2[k+i] || isUsed3[n-1 + k-i])
        continue;
      isUsed1[i] = true;
      isUsed2[k + i] = true;
      isUsed3[n - 1 + k - i] = true;
      func(k + 1);
      isUsed1[i] = false;
      isUsed2[k + i] = false;
      isUsed3[n - 1 + k - i] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    func(0);
    System.out.println(result);
  }
}


