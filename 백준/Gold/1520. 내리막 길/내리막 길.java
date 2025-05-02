import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[][] graph;
  static int[][] dp;
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  static int dfs(int x, int y) {
    if (x == m - 1 && y == n - 1) {
      return 1;
    }
    if (dp[x][y] == -1) {
      dp[x][y] = 0;
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n)
          continue;
        if (graph[x][y] <= graph[nx][ny]) {
          continue;
        }
        dp[x][y] += dfs(nx, ny); 
      }
    }
    return dp[x][y];
  }

  public static void main(String[] args) throws IOException {
    // 입력값
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    graph = new int[m][n];
    dp = new int[m][n];
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
      Arrays.fill(dp[i], -1);
    }
    System.out.println(dfs(0, 0));
  }
}