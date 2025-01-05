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
      StringTokenizer st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      char[][] graph = new char[h][w];

      Queue<int[]> fqueue = new LinkedList<>();
      Queue<int[]> jqueue = new LinkedList<>();

      int[][] fdist = new int[h][w];
      int[][] jdist = new int[h][w];
      for (int i = 0; i < h; i++) {
        String s = br.readLine();
        Arrays.fill(fdist[i], -1);
        Arrays.fill(jdist[i], -1);
        for (int j = 0; j < w; j++) {
          graph[i][j] = s.charAt(j);
          if (graph[i][j] == '@') {
            jdist[i][j] = 0;
            jqueue.offer(new int[] { i, j });
          }
          if (graph[i][j] == '*') {
            fdist[i][j] = 0;
            fqueue.offer(new int[] { i, j });
          }
        }
      }

      int[] dx = { -1, 1, 0, 0 };
      int[] dy = { 0, 0, -1, 1 };
      while (!fqueue.isEmpty()) {
        int[] fcurr = fqueue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = fcurr[0] + dx[i];
          int ny = fcurr[1] + dy[i];
          if (nx < 0 || nx >= h || ny < 0 || ny >= w)
            continue;
          if (graph[nx][ny] == '#' || fdist[nx][ny] != -1)
            continue;
          fdist[nx][ny] = fdist[fcurr[0]][fcurr[1]] + 1;
          fqueue.offer(new int[] { nx, ny });
        }
      }

      boolean flag = false;
      while (!jqueue.isEmpty()) {
        if (flag)
          break;
        int[] jcurr = jqueue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = jcurr[0] + dx[i];
          int ny = jcurr[1] + dy[i];
          if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
            System.out.println(jdist[jcurr[0]][jcurr[1]] + 1);
            flag = true;
            break;
          }
          if (graph[nx][ny] == '#' || jdist[nx][ny] != -1)
            continue;
          if (fdist[nx][ny] != -1 && jdist[jcurr[0]][jcurr[1]] + 1 >= fdist[nx][ny])
            continue;
          jdist[nx][ny] = jdist[jcurr[0]][jcurr[1]] + 1;
          jqueue.offer(new int[] { nx, ny });
        }
      }
      if (!flag) {
        System.out.println("IMPOSSIBLE");
      }
    }
  }
}