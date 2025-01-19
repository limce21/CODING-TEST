import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static char[][] matrix;

  /**
   * 1. 함수의 정의
   *    : 양 옆 직삼각형을 빈칸처리하고, 나머지 삼각형을 네등분한다. 좌표는 제일 위 꼭대기 값을 의미한다.
   * 2. base condition
   *    : cnt가 3이면 패턴을 찍고 리턴한다.
   * 3. 재귀 식
   *    : 4등분 해서 가운데 값은 빈칸처리하고, 새로운 좌표값과 cnt / 2 크기를 매개변수로 함수를 호출한다.
   **/
  static void func(int x, int y, int cnt) {
    if (cnt == 3) {
      matrix[x][y] = '*';
      matrix[x + 1][y - 1] = '*';
      matrix[x + 1][y + 1] = '*';
      matrix[x + 2][y - 2] = '*';
      matrix[x + 2][y - 1] = '*';
      matrix[x + 2][y] = '*';
      matrix[x + 2][y + 1] = '*';
      matrix[x + 2][y + 2] = '*';
      return;
    }
    int nCnt = cnt / 2;
    func(x, y, nCnt);
    func(x + nCnt, y - nCnt, nCnt);
    func(x + nCnt, y + nCnt, nCnt);
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    matrix = new char[n][n * 2];
    for (int i = 0; i < n; i++) {
      Arrays.fill(matrix[i], ' ');
    }
    func(0, n, n);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= n * 2 - 1; j++) {
        sb.append(matrix[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}


