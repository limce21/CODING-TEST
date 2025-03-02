import java.io.*;
import java.util.*;

public class Main {
  static char[][] arr = new char[5][5];
  static int result = 0;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { -1, 1, 0, 0 };
  static boolean[] mask = new boolean[25];

  static void search(int idx, int k, int yCnt) {
    if (yCnt >= 4)
      return;
    if (k == 7) {
      idx--;
      if (bfs(idx / 5, idx % 5)) {
        result++;
      }
      return;
    }
    for (int i = idx; i < 25; i++) {
      mask[i] = true;
      if(arr[i/5][i%5] == 'Y'){
        search(i + 1, k + 1, yCnt + 1);
      } else {
        search(i + 1, k + 1, yCnt);
      }
      mask[i] = false;
    }
  }
  

  static boolean bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[5][5];
    visited[x][y] = true;
    queue.offer(new int[] { x, y });
    int cnt = 1;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int cx = cur[0];
      int cy = cur[1];
      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || !mask[nx * 5 + ny])
          continue;
        visited[nx][ny] = true;
        queue.offer(new int[] { nx, ny });
        cnt++;
      }
    }
    return cnt == 7;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 5; i++) {
      String s = br.readLine();
      for (int j = 0; j < 5; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    search(0, 0, 0);
    System.out.println(result);
  }
}