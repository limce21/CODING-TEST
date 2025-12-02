import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int r;
  static int[][] graph;
  static boolean[][] visited;
  static Queue<int[]> queue = new LinkedList<>();

  public static int attack(int x, int y, int[] d) {
    int score = 1;
    queue.clear();
    visited[x][y] = true;
    queue.offer(new int[] { x, y });
    int[] cur;
    int cx, cy, k, nx, ny;
    while (!queue.isEmpty()) {
      cur = queue.poll();
      cx = cur[0];
      cy = cur[1];
      k = graph[cx][cy];
      for (int i = 1; i <= k - 1; i++) {
        nx = cx + (d[0] * i);
        ny = cy + (d[1] * i);
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (visited[nx][ny])
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
        score++;
      }
    }
    
    return score;
  }

  public static void defense(int x, int y) {
    visited[x][y] = false;
  }

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      r = Integer.parseInt(st.nextToken());
      graph = new int[n][m];
      visited = new boolean[n][m];
      HashMap<String, int[]> map = new HashMap<>();
      map.put("E", new int[] { 0, 1 });
      map.put("W", new int[] { 0, -1 });
      map.put("S", new int[] { 1, 0 });
      map.put("N", new int[] { -1, 0 });

      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
          graph[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int totalScore = 0;
      for (int i = 0; i < r; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken())-1;
        int y = Integer.parseInt(st.nextToken())-1;
        int[] d = map.get(st.nextToken());
        if (!visited[x][y]) {
          totalScore += attack(x, y, d);
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken())-1;
        y = Integer.parseInt(st.nextToken())-1;
        defense(x, y);
      }

      StringBuilder sb = new StringBuilder();
      sb.append(totalScore + "\n");
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (visited[i][j]) {
            sb.append("F ");
          } else {
            sb.append("S ");
          }
        }
        sb.append("\n");
      }
      System.out.println(sb);
  }
}


