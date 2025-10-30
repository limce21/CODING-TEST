import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] graph = new int[n][m];
    int[][] dist = new int[n][m];

    int rx = 0;
    int ry = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        dist[i][j] = -1;
        if (graph[i][j] == 2) {
          rx = i;
          ry = j;
        } else if (graph[i][j] == 0) {
          dist[i][j] = 0;
        }
      }
    }

    Queue<int[]> queue = new LinkedList<>();
    dist[rx][ry] = 0;
    queue.offer(new int[] { rx, ry });

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0];
      int cy = cur[1];
      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (dist[nx][ny] >= 0)
          continue;
        dist[nx][ny] = dist[cx][cy] + 1;
        queue.offer(new int[] { nx, ny });
      }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        sb.append(dist[i][j] + " ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}