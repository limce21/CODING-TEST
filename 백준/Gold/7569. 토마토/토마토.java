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
    int h = Integer.parseInt(st.nextToken());
    int[][][] graph = new int[h][n][m];
    int[][][] dist = new int[h][n][m];

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < m; k++) {
          graph[i][j][k] = Integer.parseInt(st.nextToken());
          if (graph[i][j][k] == 1) {
            queue.offer(new int[] { i, j, k });
          }
          if (graph[i][j][k] == 0) {
            dist[i][j][k] = -1;
          }
        }

      }
    }
    int[] dz = { -1, 1, 0, 0, 0, 0 };
    int[] dx = { 0, 0, -1, 1, 0, 0 };
    int[] dy = { 0, 0, 0, 0, -1, 1 };

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 6; i++) {
        int nz = curr[0] + dz[i];
        int nx = curr[1] + dx[i];
        int ny = curr[2] + dy[i];
        if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (graph[nz][nx][ny] == -1 || dist[nz][nx][ny] != -1)
          continue;
        dist[nz][nx][ny] = dist[curr[0]][curr[1]][curr[2]] + 1;
        queue.offer(new int[] {nz, nx, ny});
      }
    }

    int result = 0;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          if (dist[i][j][k] == -1) {
            System.out.println(-1);
            return;
          }
          result = Math.max(result, dist[i][j][k]);
        }
      }
    }
    System.out.println(result);
  }
}
