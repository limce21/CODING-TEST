import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int m;
  static int n;
  static int[][] graph;
  static boolean[][] visited;

  static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    visited[x][y] = true;
    queue.offer(new int[] { x, y });

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (graph[nx][ny] == 0 || visited[nx][ny])
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for (int c = 0; c < t; c++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      m = Integer.parseInt(st.nextToken());
      n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      graph = new int[n][m];
      visited = new boolean[n][m];
      for (int i = 0; i < k; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        graph[y][x] = 1;
      }

      int result = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (graph[i][j] == 1 && !visited[i][j]) {
            bfs(i, j);
            result++;
          }
        }
      }
      System.out.println(result);
    }
  }
}