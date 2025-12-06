import java.io.*;
import java.util.*;

public class Main {
  static int[][] sdoku = new int[9][9];
  static ArrayList<int[]> al = new ArrayList<>();

  static boolean check(int x, int y, int v) {
    // 같은 행/열 검사
    for (int i = 0; i < 9; i++) {
      if (sdoku[x][i] == v || sdoku[i][y] == v) return false;
    }
    // 3x3 박스 검사 — 시작 인덱스는 (x/3)*3, (y/3)*3
    int sx = (x / 3) * 3;
    int sy = (y / 3) * 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (sdoku[sx + i][sy + j] == v) return false;
      }
    }
    return true;
  }

  static void dfs(int idx) {
    if (idx == al.size()) {
      // 완성 출력
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(sdoku[i][j]).append(' ');
        }
        sb.append('\n');
      }
      System.out.print(sb.toString());
      System.exit(0);
    }

    int x = al.get(idx)[0];
    int y = al.get(idx)[1];

    for (int v = 1; v <= 9; v++) {
      if (check(x, y, v)) {
        sdoku[x][y] = v;
        dfs(idx + 1);
        sdoku[x][y] = 0;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        sdoku[i][j] = Integer.parseInt(st.nextToken());
        if (sdoku[i][j] == 0) {
          al.add(new int[] { i, j });
        }
      }
    }
    dfs(0);
  }
}
