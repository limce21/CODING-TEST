import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int l;
  static int r;
  static int[][] a;

  // 인접 판별함수
  static boolean bfs(int x, int y) {

    return true;
  }
 
  public static void main(String[] args) throws IOException {
    // 입력값
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int[][] a = new int[n][n];
    boolean[][] line = new boolean[n][n];
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    boolean[][] visited = new boolean[n][n];
    Queue<int[]> q = new LinkedList<>();
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };
    boolean flag;
    int popul;
    int cnt;
    
    for (int k = 0; k < 2000; k++) {
      for (int c = 0; c < n; c++) {
        Arrays.fill(line[c], false);
      }
      flag = false;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!line[i][j]) {
            for (int c = 0; c < n; c++) {
              Arrays.fill(visited[c], false);
            }
            q.clear();
            visited[i][j] = true;
            line[i][j] = true;
            q.offer(new int[] { i, j });
            popul = a[i][j];
            cnt = 1;
            while (!q.isEmpty()) {
              int[] v = q.poll();
              for (int c = 0; c < 4; c++) {
                int nx = v[0] + dx[c];
                int ny = v[1] + dy[c];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                  continue;
                if (line[nx][ny] || visited[nx][ny])
                  continue;
                int abs = Math.abs(a[v[0]][v[1]] - a[nx][ny]);
                if (abs >= l && abs <= r) {
                  line[nx][ny] = true;
                  visited[nx][ny] = true;
                  popul += a[nx][ny];
                  cnt++;
                  q.offer(new int[] { nx, ny });
                }
              }
            }

            if (cnt != 1) {
              int val = Math.floorDiv(popul, cnt);
              for (int aa = 0; aa < n; aa++) {
                for (int ab = 0; ab < n; ab++) {
                  if (visited[aa][ab]) {
                    a[aa][ab] = val;
                  }
                }
              }
              flag = true;
            }
          }
        }
      }

      if (!flag) {
        System.out.println(k);
        return;
      }
    }
  }
}

