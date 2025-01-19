import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int[][] matrix;
  static int white;
  static int blue;

  /**
   * 1. 함수의 정의
   *    : 매트릭스를 탐색하면서 처음 좌표값과 다른 값이 나오면 재귀를 시작한다.
   * 2. base condition
   *    : cnt가 1이면 자신의 값을 +1 해준다.
   * 3. 재귀 식
   *    : 4등분으로 좌표를 쪼개고, 새로운 좌표값과 cnt / 2를 가지고 함수를 호출한다.
   **/
  static void func(int x, int y, int cnt) {
    if (cnt == 1) {
      if (matrix[x][y] == 1)
        blue++;
      else
        white++;
      return;
    }
    int first = matrix[x][y];
    int nCnt = cnt / 2;
    for (int i = 0; i < cnt; i++) {
      for (int j = 0; j < cnt; j++) {
        if (matrix[x + i][y + j] != first) {
          func(x, y, nCnt);
          func(x, y + nCnt, nCnt);
          func(x + nCnt, y, nCnt);
          func(x + nCnt, y + nCnt, nCnt);
          return;
        }
      }
    }
    if (first == 1)
      blue++;
    else
      white++;
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    func(0, 0, n);
    System.out.println(white);
    System.out.println(blue);
  }
}

