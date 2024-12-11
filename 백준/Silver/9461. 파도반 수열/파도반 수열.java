import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long[] dp = new long[101];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    for (int i = 5; i <= 100; i++) {
      dp[i] = dp[i - 1] + dp[i - 5];
    }
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      System.out.println(dp[N]);
    }
  }
}
