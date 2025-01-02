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
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int[][] graph = new int[r][c];
    int[][] fire = new int[r][c];
    int[][] dist = new int[r][c];

    Queue<int[]> fqueue = new LinkedList<>();
    Queue<int[]> jqueue = new LinkedList<>();

    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        char code = s.charAt(j);
        switch (code) {
          case '#':
            graph[i][j] = -1;
            dist[i][j] = -1;
            fire[i][j] = -1;
            break;
          case '.':
            dist[i][j] = -1;
            fire[i][j] = -1;
            break;
          case 'J':
            dist[i][j] = 0;
            fire[i][j] = -1;
            jqueue.offer(new int[] { i, j });
            break;
          case 'F':
            fire[i][j] = 0;
            dist[i][j] = -1;
            fqueue.offer(new int[] { i, j });
            break;
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
        if (nx < 0 || nx >= r || ny < 0 || ny >= c)
          continue;
        if (graph[nx][ny] == -1 || fire[nx][ny]  >= 0)
          continue;
        fire[nx][ny] = fire[fcurr[0]][fcurr[1]] + 1;
        fqueue.offer(new int[] { nx, ny });
      }
    }
    
    while (!jqueue.isEmpty()) {
      int[] jcurr = jqueue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = jcurr[0] + dx[i];
        int ny = jcurr[1] + dy[i];
        if (nx < 0 || nx >= r || ny < 0 || ny >= c) {
          System.out.println(dist[jcurr[0]][jcurr[1]]+1);
          return;
        }
        if (graph[nx][ny] == -1 || dist[nx][ny] >= 0) continue;
        if( fire[nx][ny] >= 0  && dist[jcurr[0]][jcurr[1]] + 1 >= fire[nx][ny])
          continue;
        dist[nx][ny] = dist[jcurr[0]][jcurr[1]] + 1;
        jqueue.offer(new int[] { nx, ny });
      }
    }
    System.out.println("IMPOSSIBLE");
  }
}