import java.io.*;

public class Main {
  static StringBuilder sb = new StringBuilder();
  
  // 원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 방법을 출력하는 함수.
  static void func(int n, int a, int b) {
    // base condition : n == 1일때, a에서 b를 출력한다.
    if (n == 1) {
      sb.append(a + " " + b + "\n");
      return;
    }
    // 재귀 내용
    // n-1을 a에서 6-a-b로 옮긴다.
    func(n - 1, a, 6 - a - b);
    // n번 원판 한개를 a에서 b로 옮긴다.
    sb.append(a + " " + b + "\n");
    // n-1을 6-a-b에서 b로 옮긴다.
    func(n - 1, 6 - a - b, b);
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    System.out.println((1<<k)- 1);
    func(k, 1, 3);
    System.out.print(sb);
  }
}