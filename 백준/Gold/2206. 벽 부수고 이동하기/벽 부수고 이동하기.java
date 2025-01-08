import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] graph = new int[n][m];
    boolean[][][] visited = new boolean[n][m][2];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    Queue<int[]> queue = new LinkedList<>();
    visited[0][0][0] = true;
    queue.offer(new int[] { 0, 0, 1, 0 });

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int cx = curr[0];
      int cy = curr[1];
      int cnt = curr[2];
      int isBroken = curr[3];
      if (cx == n - 1 && cy == m - 1) {
        System.out.println(cnt);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        int ncnt = cnt + 1;
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (graph[nx][ny] == 0) {
          if (isBroken == 0 && !visited[nx][ny][0]) {
            visited[nx][ny][0] = true;
            queue.offer(new int[] { nx, ny, ncnt, 0 });
          } else if (isBroken == 1 && !visited[nx][ny][1]) {
            visited[nx][ny][1] = true;
            queue.offer(new int[] { nx, ny, ncnt, 1 });
          }
        } else if (graph[nx][ny] == 1 && isBroken == 0) {
          visited[nx][ny][0] = true;
          queue.offer(new int[] { nx, ny, ncnt, 1 });
        }
      }
    }
    System.out.println(-1);
  }
}