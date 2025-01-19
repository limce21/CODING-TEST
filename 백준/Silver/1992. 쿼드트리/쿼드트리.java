import java.io.*;

public class Main {
  static int n;
  static int[][] matrix;
  static StringBuffer sb = new StringBuffer();

  /**
   * 1. 함수의 정의
   *    : 매트릭스를 탐색하면서 처음 좌표값과 다른 값이 나오면 괄호를 열고 재귀를 시작한다. 
   *      재귀가 끝나면 괄호를 닫고 리턴한다.
   * 2. base condition
   *    : cnt가 1이면 자신의 값을 출력하고 리턴한다.
   * 3. 재귀 식
   *    : 4등분으로 좌표를 쪼개고, 새로운 좌표값과 cnt / 2를 가지고 함수를 호출한다.
   **/
  static void func(int x, int y, int cnt) {
    if (cnt == 1) {
      sb.append(matrix[x][y]);
      return;
    }
    int first = matrix[x][y];
    int nCnt = cnt / 2;
    for (int i = 0; i < cnt; i++) {
      for (int j = 0; j < cnt; j++) {
        if (matrix[x + i][y + j] != first) {
          sb.append("(");
          func(x, y, nCnt);
          func(x, y + nCnt, nCnt);
          func(x + nCnt, y, nCnt);
          func(x + nCnt, y + nCnt, nCnt);
          sb.append(")");
          return;
        }
      }
    }
    sb.append(first);
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < n; j++) {
        matrix[i][j] = s.charAt(j) - '0';
      }
    }
    func(0, 0, n);
    System.out.println(sb);
  }
}

