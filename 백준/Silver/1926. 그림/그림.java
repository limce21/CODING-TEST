import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int m;
  static int[][] graph;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    graph = new int[n][m];
    visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        graph[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    int maxArea = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (graph[i][j] == 1 && !visited[i][j]) {
          // bfs를 시작한다.
          int area = bfs(i, j);
          cnt++;
          maxArea = Math.max(maxArea, area);
        }
      }
    }

    System.out.println(cnt);
    System.out.println(maxArea);
  }

  public static int bfs(int x, int y) {
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[] {x, y});
    int area = 1;

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (visited[nx][ny] || graph[nx][ny] != 1)
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
        area++;
      }
    }
    return area;
  }
}
