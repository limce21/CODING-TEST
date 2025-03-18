import java.io.*;
import java.util.*;

import javax.naming.LinkException;

public class Main {
  static int n;
  static int m;
  static int[][] arr;
  static int[][] winds;
  static LinkedList<int[]> aircs = new LinkedList<int[]>();

  static void func(int x, int y, int dir) {
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    int cx = x;
    int cy = y;

    while (true) {
      int nx = cx + dx[dir];
      int ny = cy + dy[dir];

      if (nx < 0 || nx >= n || ny < 0 || ny >= m)
        return;
      winds[nx][ny] = 1;
      if (arr[nx][ny] == 1 && (dir == 0 || dir == 1)) {
        return;
      }
      if (arr[nx][ny] == 2 && (dir == 2 || dir == 3)) {
        return;
      }
      if (arr[nx][ny] == 3) {
        if (dir == 0) {
          dir = 3;
        } else if (dir == 1) {
          dir = 2;
        } else if (dir == 2) {
          dir = 1;
        } else {
          dir = 0;
        }
      }
      if (arr[nx][ny] == 4) {
        if (dir == 0) {
          dir = 2;
        } else if (dir == 1) {
          dir = 3;
        } else if (dir == 2) {
          dir = 0;
        } else {
          dir = 1;
        }
      }
      cx = nx;
      cy = ny;
    }

  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n][m];
    winds = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (arr[i][j] == 9) {
          aircs.add(new int[] { i, j });
        }
      }
    }

    for (int i = 0; i < aircs.size(); i++) {
      int[] tmp = aircs.get(i);
      int x = tmp[0];
      int y = tmp[1];
      for (int j = 0; j < 4; j++) {
        winds[x][y] = 1;
        func(x, y, j);
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (winds[i][j] == 1) {
          result++;
        }
      }
    }
    System.out.println(result);
  }
}


