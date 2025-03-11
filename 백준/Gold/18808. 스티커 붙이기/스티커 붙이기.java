import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int k;
  static int[][] notebook;
  static int[][] sticker;
  static int result = 0;

  static void rotate(int r, int c, int angle) {
    if (angle == 0) {
      return;
    }
    int[][] tmp = new int[c][r];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        tmp[j][r - 1 - i] = sticker[i][j];
      }
    }
    sticker = tmp;
    return;
  }

  static boolean search() {
    int r = sticker.length;
    int c = sticker[0].length;

    for (int x = 0; x < n; x++) {
      for (int y = 0; y < m; y++) {
        // 이제 붙일 수 있는지 판별
        if (find(x, y, r, c)) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean find(int x, int y, int r, int c) {

    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (x + i >= n || y + j >= m) {
          return false;
        }
          
        if (sticker[i][j] == 1 && notebook[x + i][y + j] != 0) {
          return false;
        }
          
      }
    }
    
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (sticker[i][j] == 1) {
          notebook[x + i][y + j] = 1;
          result++;
        }
      }
    }
    return true;
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    notebook = new int[n][m];

    for (int t = 0; t < k; t++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      sticker = new int[r][c];

      for (int x = 0; x < r; x++) {
        st = new StringTokenizer(br.readLine());
        for (int y = 0; y < c; y++) {
          sticker[x][y] = Integer.parseInt(st.nextToken());
        }
      }

      for (int i = 0; i < 4; i++) {
        int tr = sticker.length;
        int tc = sticker[0].length;
        rotate(tr, tc, i);
        if (search())
          break;
      }
    }
    System.out.println(result);
  }
}