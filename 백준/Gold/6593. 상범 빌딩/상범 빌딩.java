import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int l = Integer.parseInt(st.nextToken());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if (l == 0 && r == 0 && c == 0) {
        return;
      }

      char[][][] graph = new char[l][r][c];
      int[][][] dist = new int[l][r][c];
      Queue<int[]> queue = new LinkedList<>();
      for (int i = 0; i < l; i++) {
        for (int j = 0; j < r; j++) {
          String s = br.readLine();
          for (int k = 0; k < c; k++) {
            graph[i][j][k] = s.charAt(k);
            dist[i][j][k] = -1;
            if (graph[i][j][k] == 'S') {
              dist[i][j][k] = 0;
              queue.offer(new int[] { i, j, k });
            }
          }
        }
        br.readLine();
      }
      int[] dl = { -1, 1, 0, 0, 0, 0 };
      int[] dr = { 0, 0, -1, 1, 0, 0 };
      int[] dc = { 0, 0, 0, 0, -1, 1 };

      int result = -1;
      while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        if (graph[curr[0]][curr[1]][curr[2]] == 'E') {
          result = dist[curr[0]][curr[1]][curr[2]];
          break;
        }
        for (int i = 0; i < 6; i++) {
          int nl = curr[0] + dl[i];
          int nr = curr[1] + dr[i];
          int nc = curr[2] + dc[i];
          if (nl < 0 || nl >= l || nr < 0 || nr >= r || nc < 0 || nc >= c)
            continue;
          if (graph[nl][nr][nc] == '#' || dist[nl][nr][nc] != -1)
            continue;
          dist[nl][nr][nc] = dist[curr[0]][curr[1]][curr[2]] + 1;
          queue.offer(new int[] { nl, nr, nc });
        }
      }
      if (result != -1) {
        System.out.println("Escaped in " + result + " minute(s).");
      } else {
        System.out.println("Trapped!");
      }
    }
  }
}