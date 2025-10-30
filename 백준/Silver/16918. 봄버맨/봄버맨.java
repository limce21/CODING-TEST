import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    char[][] graph = new char[r][c];

    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < r; i++) {
      String str = br.readLine();
      for (int j = 0; j < c; j++) {
        graph[i][j] = str.charAt(j);
      }
    }

    char[][] result = new char[r][c];
    int[] dx = { 1, -1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    if (n == 1) {
      result = graph;
    } else if (n % 2 == 0) {
      for (int i = 0; i < r; i++) {
        Arrays.fill(result[i], 'O');
      }
    } else if (n % 4 == 1) {
      result = graph;
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (graph[i][j] == 'O') {
            queue.offer(new int[] { i, j });
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int cx = cur[0];
        int cy = cur[1];
        for (int i = 0; i < 4; i++) {
          int nx = cx + dx[i];
          int ny = cy + dy[i];
          if (nx < 0 || nx >= r || ny < 0 || ny >= c)
            continue;
          if (result[nx][ny] == 'O') continue;
          result[nx][ny] = 'O';
        }
      }

      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (result[i][j] == '.') {
            queue.offer(new int[] { i, j });
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int cx = cur[0];
        int cy = cur[1];
        for (int i = 0; i < 4; i++) {
          int nx = cx + dx[i];
          int ny = cy + dy[i];
          if (nx < 0 || nx >= r || ny < 0 || ny >= c)
            continue;
          if (result[nx][ny] == '.')
            continue;
          result[nx][ny] = '.';
        }
      }
      
    } else {
      for (int i = 0; i < r; i++) {
        Arrays.fill(result[i], 'O');
      }

      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          if (graph[i][j] == 'O') {
            result[i][j] = '.';
            queue.offer(new int[] { i, j });
          }
        }
      }

      while (!queue.isEmpty()) {
        int[] cur = queue.poll();
        int cx = cur[0];
        int cy = cur[1];
        for (int i = 0; i < 4; i++) {
          int nx = cx + dx[i];
          int ny = cy + dy[i];
          if (nx < 0 || nx >= r || ny < 0 || ny >= c)
            continue;
          result[nx][ny] = '.';
        }
      }
    }
    
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        sb.append(result[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}