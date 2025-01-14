import java.io.*;
import java.util.StringTokenizer;

public class Main {
  static int r;
  static int c;
  static int[] dx = { 0, 0, 1, 1 };
  static int[] dy = { 0, 1, 0, 1 };
  // func : (2^n) * (2^n) 배열을 방문하는 함수
  static void func(int n, int x, int y, int cnt) {
    //System.out.println(n + " " + x + " " + y + " " + cnt);
    // base condition : n == 1이면 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순으로 방문한다.
    if (n == 2) {
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        cnt++;
        //System.out.println("test2 " + nx + " " + ny + " " + cnt);
        if (nx == r && ny == c) {
          System.out.println(cnt);
          return;
        }
      }
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i] * (n / 2);
      int ny = y + dy[i] * (n / 2);
      if (r >= nx && r < nx + (n / 2) && c >= ny && c < ny + (n / 2)) {
        //System.out.println("test1 " + x + " " + y + " " + nx + " " + ny);
        func(n / 2, nx, ny, cnt);
      } else {
        cnt += (int)Math.pow((n / 2), 2);
        continue;
      }

    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    func(1<<n, 0, 0, -1);
  }
}

