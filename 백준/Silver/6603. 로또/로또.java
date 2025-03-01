import java.io.*;
import java.util.*;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static StringTokenizer st;
  static int k;
  static int[] arr;
  static int[] number;
  static boolean[] isUsed;

  static void func(int cur) {
    if (cur == 6) {
      for (int i = 0; i < 6; i++) {
        sb.append(arr[i] + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 0; i < k; i++) {
      if (!isUsed[i]) {
        if (cur == 0) {
          isUsed[i] = true;
          arr[cur] = number[i];
          func(cur + 1);
          isUsed[i] = false;          
        } else if (number[i] >= arr[cur - 1]) {
          isUsed[i] = true;
          arr[cur] = number[i];
          func(cur + 1);
          isUsed[i] = false;
        }
      }
    }
  }


  public static void main(String[] args) throws IOException {
    while (true) {
      st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
      if (k == 0) {
        System.out.println(sb);
        return;
      }
    
      arr = new int[k];
      number = new int[k];
      isUsed = new boolean[k];
      for (int i = 0; i < k; i++) {
        number[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(number);
      func(0);
      sb.append("\n");
    }
  }
}