import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[][] graph;
  static boolean[][] visited;

  static int bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    visited[x][y] = true;
    queue.offer(new int[] { x, y });

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int area = 0;
    while (!queue.isEmpty()) {
      area++;
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= n)
          continue;
        if (graph[nx][ny] == 0 || visited[nx][ny])
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
      }
    }
    return area;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    graph = new int[n][n];
    visited = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        graph[i][j] = s.charAt(j) - '0';
      }
    }
    
    ArrayList<Integer> areaList = new ArrayList<Integer>();
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] != 0 && !visited[i][j]) {
          cnt++;
          int area = bfs(i, j);
          areaList.add(area);
        }
      }
    }
    Collections.sort(areaList);
    System.out.println(cnt);
    for (int i = 0; i < cnt; i++) {
      System.out.println(areaList.get(i));
    }
  }
}