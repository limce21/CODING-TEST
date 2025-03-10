import java.io.*;
import java.util.*;

public class Main {
  static int[][] arr;
  static boolean[] player;
  static int result;

  static void search(int k, int sum) {
    if (k == 11) {
      result = Math.max(result, sum);
      return;
    }
    for (int i = 0; i < 11; i++) {
      if (arr[i][k] != 0 && !player[i]) {
        player[i] = true;
        search(k + 1, sum + arr[i][k]);
        player[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int c = Integer.parseInt(br.readLine());

    for (int t = 0; t < c; t++) {
      arr = new int[11][11];
      result = 0;
      player = new boolean[11];
      for (int i = 0; i < 11; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 11; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      search(0, 0);
      System.out.println(result);
    }
  }
}