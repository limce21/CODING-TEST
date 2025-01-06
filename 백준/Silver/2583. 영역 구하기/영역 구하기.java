import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  static int m;
  static int n;
  static int k;
  static int[][] graph;
  static int[][] visited;

  static int bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = 1;
    queue.offer(new int[] { x, y });

    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    int area = 0;
    while (!queue.isEmpty()) {
      area++;
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n)
          continue;
        if (graph[nx][ny] == 1 || visited[nx][ny] != -1)
          continue;
        visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
        queue.offer(new int[] { nx, ny });
      }
    }
    return area;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    graph = new int[m][n];
    visited = new int[m][n];
    for (int i = 0; i < m; i++) {
      Arrays.fill(visited[i], -1);
    }
    for (int cnt = 0; cnt < k; cnt++) {
      st = new StringTokenizer(br.readLine());
      int lx = Integer.parseInt(st.nextToken());
      int ly = Integer.parseInt(st.nextToken());
      int rx = Integer.parseInt(st.nextToken());
      int ry = Integer.parseInt(st.nextToken());
      for (int i = ly; i < ry; i++) {
        for (int j = lx; j < rx; j++) {
          graph[i][j] = 1;
        }
      }
    }

    int result = 0;
    ArrayList<Integer> areaArr = new ArrayList<Integer>(); 
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 0 && visited[i][j] == -1) {
          int area = bfs(i, j);
          areaArr.add(area);
          result++;
        }
      }
    }

    System.out.println(result);
    Collections.sort(areaArr);
    for (int i = 0; i < result; i++) {
      System.out.print(areaArr.get(i) + " ");
    }
    System.out.println();
  }
}