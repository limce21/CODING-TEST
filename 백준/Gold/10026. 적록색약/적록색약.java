import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int n;
  static char[][] graph;
  static boolean[][] visited;

  static void bfs1(int x, int y, char color) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[] { x, y });
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
          continue;
        if (graph[nx][ny] != color || visited[nx][ny])
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
      }
    }
  }

  static void bfs2(int x, int y, char color) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[] { x, y });
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
          continue;
        if (color == 'B') {
          if (graph[nx][ny] != 'B' || visited[nx][ny])
            continue;
        } else {
          if(graph[nx][ny] == 'B' || visited[nx][ny])
            continue;
        }
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new char[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        graph[i][j] = s.charAt(j);
      }
    }

    int result1 = 0;
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          bfs1(i, j, graph[i][j]);
          result1++;
        }
      }
    }

    int result2 = 0;
    visited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!visited[i][j]) {
          bfs2(i, j, graph[i][j]);
          result2++;
        }
      }
    }

    System.out.println(result1 + " " + result2);
  }
}