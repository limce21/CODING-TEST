import java.io.*;
import java.util.*;

public class Main {
  static int r;
  static int c;
  static int k;
  static char[][] arr;
  static int[] dx = { 0, 0, -1, 1 };
  static int[] dy = { -1, 1, 0, 0 };
  static int result = 0;
  static int[][] visited;

  static void search(int x, int y) {
    if (x == 0 && y == c - 1) {
      if (visited[x][y] == k) {
        result++;
      }
      return;
    }
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx < 0 || nx >= r || ny < 0 || ny >= c || visited[nx][ny] > 0 || arr[nx][ny] == 'T')
        continue;
      visited[nx][ny] = visited[x][y] + 1;
      search(nx, ny);
      visited[nx][ny] = 0;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = new char[r][c];
    visited = new int[r][c];
    for (int i = 0; i < r; i++) {
      String s = br.readLine();
      for (int j = 0; j < c; j++) {
        arr[i][j] = s.charAt(j);
      }
    }

    visited[r-1][0] = 1;
    search(r-1, 0);
    System.out.println(result);

  }
}