import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[][] graph;
  static boolean[][] visited;

  static void bfs(int x, int y, int h) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[] { x, y });

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
          continue;
        if (graph[nx][ny] <= h || visited[nx][ny])
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];
    int minH = 0;
    int maxH = 0;
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        minH = Math.min(minH, graph[i][j]);
        maxH = Math.max(maxH, graph[i][j]);
      }
    }
  
    int result = 0;
    for (int f = minH; f <= maxH; f++) {
      visited = new boolean[n][n];
      int cnt = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (graph[i][j] > f && !visited[i][j]) {
            bfs(i, j, f);
            cnt++;
          }
        }
      }
      result = Math.max(result, cnt);
    }
    System.out.println(result);
  }
}