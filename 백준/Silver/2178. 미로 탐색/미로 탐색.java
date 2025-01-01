import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] graph = new int[n][m];
    int[][] dist = new int[n][m];

    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = s.charAt(j) - '0';
        dist[i][j] = -1;
      }
    }
    
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    Queue<int[]> queue = new LinkedList<>();
    dist[0][0] = 1;
    queue.offer(new int[] { 0, 0 });

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = curr[0] + dx[i];
        int ny = curr[1] + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          continue;
        if (dist[nx][ny] != -1 || graph[nx][ny] == 0)
          continue;
        dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
        queue.offer(new int[] { nx, ny });
      }
    }

    int result = dist[n - 1][m - 1];
    System.out.println(result);
  }
}
