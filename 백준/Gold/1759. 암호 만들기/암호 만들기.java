import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int l;
  static int c;
  static char[] arr;
  static char[] aArr;
  static boolean[] isUsed = new boolean[26];

  static void func(int k, int cCnt, int vCnt) {
    if (k == l && vCnt >= 1 && cCnt >= 2) {
      for (int i = 0; i < l; i++) {
        sb.append(arr[i]);
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < c; i++) {
      int idx = aArr[i] - 'a';
      if (!isUsed[idx]) {
        if (k == 0) {
          isUsed[idx] = true;
          arr[k] = aArr[i];
          if (aArr[i] == 'a' || aArr[i] == 'e' || aArr[i] == 'i' || aArr[i] == 'o' || aArr[i] == 'u') {
            func(k + 1, cCnt, vCnt + 1);
          } else {
            func(k + 1, cCnt + 1, vCnt);
          }
          isUsed[idx] = false;          
        } else if (idx >= arr[k - 1] - 'a') {
          isUsed[idx] = true;
          arr[k] = aArr[i];
          if (aArr[i] == 'a' || aArr[i] == 'e' || aArr[i] == 'i' || aArr[i] == 'o' || aArr[i] == 'u') {
            func(k + 1, cCnt, vCnt + 1);
          } else {
            func(k + 1, cCnt + 1, vCnt);
          }
          isUsed[idx] = false;          
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    aArr = new char[c];
    arr = new char[c];

    for (int i = 0; i < c; i++) {
      aArr[i] = (st.nextToken()).charAt(0);
    }
    Arrays.sort(aArr);

    func(0, 0, 0);
    System.out.println(sb);
  }
}