import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int h;
  static int[][] arr;
  static int answer = Integer.MAX_VALUE;
  static boolean[][] visited;

  static boolean func() {
    for (int i = 0; i < n; i++) {
      int end = i;
      for (int j = 0; j < h; j++) {
        if (end > 0 && arr[j][end - 1] == 1) { // 좌측이동
          end -= 1;
        } else if (end < n-1 && arr[j][end] == 1) { // 우측이동
          end += 1;
        }
      }
      if (end != i) {
        return false;
      }
    }
    return true;
  }

  static void search(int c, int a, int b) {
    if (func()) {
      answer = Math.min(answer, c);
      return;
    }
    if (c == 3) {
      return;
    }
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j])
          continue;
        if (arr[i][j] == 1)
          continue;
        if(j > 0 && arr[i][j-1] == 1)
          continue;
        arr[i][j] = 1;
        visited[i][j] = true;
        search(c + 1, i, j);
        arr[i][j] = 0;
        visited[i][j] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    h = Integer.parseInt(st.nextToken());
    arr = new int[h][n];
    visited = new boolean[h][n];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a - 1][b - 1] = 1;
    }

    search(0, 0, 0);
    if (answer == Integer.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
  }
}
