import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[][] w;
  static int first;
  static int result = Integer.MAX_VALUE;
  static boolean[] visited;

  static void search(int k, int x, int cost) {
    if (k == n) {
      if (x == first) {
        result = Math.min(result, cost);
      }
    }
    for (int i = 0; i < n; i++) {
      if (!visited[i] && w[x][i] != 0) {
        visited[i] = true;
        int val = cost + w[x][i];
        search(k + 1, i, val);
        visited[i] = false;
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    w = new int[n][n];
    visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        w[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < n; i++) {
      first = i;
      search(0, i, 0);
    }
    System.out.println(result);
  }
}

