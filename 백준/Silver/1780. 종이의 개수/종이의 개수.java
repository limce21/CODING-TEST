import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static int[][] matrix;
  static int result1; // -1
  static int result2; //  0
  static int result3; // +1

  /**
   * 1. 함수의 정의
   *    : 매트릭스를 탐색하면서 처음 좌표값과 다른 값이 나오면 재귀를 시작한다.
   * 2. base condition
   *    : cnt가 1이면 자신의 값을 +1 해준다.
   * 3. 재귀 식
   *    : 질문까지의 내용을 출력하고, cnt + 1 을 호출한다.
   **/
  static void func(int x, int y, int cnt) {
    if (cnt == 1) {
      switch (matrix[x][y]) {
        case -1:
          result1++;
          break;
        case 0:
          result2++;
          break;
        case 1:
          result3++;
          break;
      }
      return;
    }
    int first = matrix[x][y];
    int nCnt = cnt / 3;
    for (int i = 0; i < cnt; i++) {
      for (int j = 0; j < cnt; j++) {
        if (matrix[x + i][y + j] != first) {
          func(x, y, nCnt);
          func(x, y + nCnt, nCnt);
          func(x, y + 2 * nCnt, nCnt);
          func(x + nCnt, y, nCnt);
          func(x + nCnt, y + nCnt, nCnt);
          func(x + nCnt, y + 2 * nCnt, nCnt);
          func(x + 2 * nCnt, y, nCnt);
          func(x + 2 * nCnt, y + nCnt, nCnt);
          func(x + 2 * nCnt, y + 2 * nCnt, nCnt);
          return;
        }
      }
    }
    switch (first) {
      case -1:
        result1 ++;
        break;
      case 0:
        result2 ++;
        break;
      case 1:
        result3 ++;
        break;
    }
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    matrix = new int[n][n];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        matrix[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    func(0, 0, n);
    System.out.println(result1);
    System.out.println(result2);
    System.out.println(result3);
  }
}

