import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    Queue<int[]> queue = new LinkedList<>();
    int[][] graph = new int[n][m];
    int[][] dist = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        if (graph[i][j] == 1) {
          queue.offer(new int[] { i, j });
        }
        if (graph[i][j] == 0) {
          dist[i][j] = -1;
        }
      }
    }

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (graph[nx][ny] == -1 || dist[nx][ny] != -1)
          continue;
        dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
        queue.offer(new int[] {nx, ny});
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (dist[i][j] == -1) {
          System.out.println(-1);
          return;
        }
        result = Math.max(result, dist[i][j]);
      }
    }
    System.out.println(result);
  }
}
