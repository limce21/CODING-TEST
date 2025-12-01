import java.io.*;
import java.util.*;

public class Main {
  static int r;
  static int c;
  static char[][] graph;
  static char[][] arr;


  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      graph = new char[r][c];
      arr = new char[r][c];
      Queue<int[]> queue = new LinkedList<>();
      for (int i = 0; i < r; i++) {
        String s = br.readLine();
        for (int j = 0; j < c; j++) {
          graph[i][j] = s.charAt(j);
          if (graph[i][j] == 'X') {
            queue.offer(new int[] { i, j });
          }
          arr[i][j] = '.';
        }
        
      }

      int[] dx = { -1, 1, 0, 0 };
      int[] dy = { 0, 0, -1, 1 };
      int minX = r-1;
      int maxX = 0;
      int minY = c-1;
      int maxY = 0;

      while (!queue.isEmpty()) {
        int cnt = 0;
        int[] island = queue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = island[0] + dx[i];
          int ny = island[1] + dy[i];
          if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
            cnt++;
            continue;
          }
          if (graph[nx][ny] == '.') {
            cnt++;
            continue;
          }
        }
        if (cnt < 3) {
          arr[island[0]][island[1]] = 'X';
          minX = Math.min(island[0], minX);
          maxX = Math.max(island[0], maxX);
          minY = Math.min(island[1], minY);
          maxY = Math.max(island[1], maxY);
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int i = minX; i <= maxX; i++) {
        for (int j = minY; j <= maxY; j++) {
          sb.append(arr[i][j]);
        }
        sb.append('\n');
      }
      System.out.println(sb);
  }
}
