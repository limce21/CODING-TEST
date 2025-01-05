import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int c = 0; c < t; c++) {
      int l = Integer.parseInt(br.readLine());
      int[][] dist = new int[l][l];
      for (int i = 0; i < l; i++) {
        Arrays.fill(dist[i], -1);
      }
      
      // 나이트가 현재 있는 칸 (cx, cy)
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cx = Integer.parseInt(st.nextToken());
      int cy = Integer.parseInt(st.nextToken());

      // 나이트가 이동하려는 칸 (tx, ty)
      st = new StringTokenizer(br.readLine());
      int tx = Integer.parseInt(st.nextToken());
      int ty = Integer.parseInt(st.nextToken());

      Queue<int[]> queue = new LinkedList<>();
      dist[cx][cy] = 0;
      queue.offer(new int[] { cx, cy });

      while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        if (curr[0] == tx && curr[1] == ty) {
          System.out.println(dist[tx][ty]);
          break;
        }
        int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1};
        int[] dy = {-1, 1, -2, 2, -1, 1, -2, 2};
        for (int i = 0; i < 8; i++) {
          int nx = curr[0] + dx[i];
          int ny = curr[1] + dy[i];
          if (nx < 0 || nx >= l || ny < 0 || ny >= l)
            continue;
          if (dist[nx][ny] != -1)
            continue;
          dist[nx][ny] = dist[curr[0]][curr[1]] + 1;
          queue.offer(new int[] { nx, ny });
        }
      }
    }
  }
}