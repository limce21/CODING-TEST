import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static char[] arr;
  static int[] isUsed;
  static int len;
  static StringBuilder sb = new StringBuilder();

  static void search(int k) {
    if (k == len) {
      for (int i = 0; i < len; i++) {
        sb.append(arr[i]);
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < 26; i++) {
      if (isUsed[i] == 0)
        continue;
      isUsed[i] -= 1;
      arr[k] = (char)(i + 97);
      search(k + 1);
      isUsed[i] += 1;
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      len = s.length();
      arr = new char[len];
      isUsed = new int[26];
      for (int j = 0; j < len; j++) {
        arr[j] = s.charAt(j);
        int val = s.charAt(j) - 'a';
        isUsed[val] += 1;
      }
      search(0);
    }
    System.out.println(sb);
  }
}