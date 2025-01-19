import java.io.*;

public class Main {
  static int n;
  static char[][] matrix;

  static void blank(int x, int y, int cnt) {
    for (int i = 0; i < cnt; i++) {
      for (int j = 0; j < cnt; j++) {
        matrix[x + i][y + j] = ' ';
      }
    }
    return;
  }

  /**
   * 1. 함수의 정의
   *    : 9등분으로 나눠 가운데 부분만 빼고 함수를 호출하는데, 3등분이 끝날때마다 \n을 추가한다.
   * 2. base condition
   *    : cnt가 3이면 패턴대로 matrix에 세팅한다.
   * 3. 재귀 식
   *    : 9등분으로 쪼갠 새로운 좌표값과 cnt / 3를 가지고 함수를 호출한다.
   **/
  static void func(int x, int y, int cnt) {
    if (cnt == 1) {
      matrix[x][y] = '*';
      return;
    }
    int nCnt = cnt / 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
          blank(x + i * nCnt, y + j * nCnt, nCnt);
        } else {
          func(x + i * nCnt, y + j * nCnt, nCnt);
        }
      }
    }
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    matrix = new char[n][n];
    
    func(0, 0, n);

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(matrix[i][j]);
      }
      sb.append('\n');
    }
    System.out.println(sb);
  }
}

