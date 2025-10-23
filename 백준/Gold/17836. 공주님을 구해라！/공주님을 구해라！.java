import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int[][] graph = new int[n][m];
    int[][][] dist = new int[n][m][2];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
        dist[i][j][0] = -1;
        dist[i][j][1] = -1;
      }
    }

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[] { 0, 0, 0 });
    dist[0][0][0] = 0;
    
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];
      int hasGram = cur[2];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (hasGram == 1) {
          if (dist[nx][ny][hasGram] >= 0)
            continue;
          dist[nx][ny][hasGram] = dist[cx][cy][hasGram] + 1;
          q.offer(new int[] { nx, ny, 1 });
        } else {
          if (graph[nx][ny] == 2) {
            dist[nx][ny][1] = dist[cx][cy][0] + 1;
            q.offer(new int[] { nx, ny, 1 });
          } else if (graph[nx][ny] != 1 && dist[nx][ny][hasGram] < 0) {
            dist[nx][ny][0] = dist[cx][cy][0] + 1;
            q.offer(new int[] { nx, ny, 0 });
          }
        }
      }
    }
    int answer = 0;
    if (dist[n - 1][m - 1][0] > 0 && dist[n - 1][m - 1][1] > 0) {
      answer = Math.min(dist[n - 1][m - 1][0], dist[n - 1][m - 1][1]);
    } else if (dist[n - 1][m - 1][0] < 0 && dist[n - 1][m - 1][1] < 0) {
      System.out.println("Fail");
      return;
    } else if (dist[n - 1][m - 1][0] < 0) {
      answer = dist[n - 1][m - 1][1];
    } else if (dist[n - 1][m - 1][1] < 0) {
      answer = dist[n - 1][m - 1][0];
    }
    if (answer <= t) {
      System.out.println(answer);
    } else {
      System.out.println("Fail");
    }
  }
}