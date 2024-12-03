import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    
    int[] scores = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      scores[i] = Integer.parseInt(br.readLine());
    }

    if (n == 1) {
      System.out.println(scores[1]);
      return;
    }

    int[][] dp = new int[n + 1][3];
    dp[1][1] = scores[1];
    dp[2][1] = scores[2];
    dp[2][2] = scores[1] + scores[2];

    for (int i = 3; i <= n; i++) {
      dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + scores[i];
      dp[i][2] = dp[i - 1][1] + scores[i];
    }

    int result = Math.max(dp[n][1], dp[n][2]);
    System.out.println(result);
    
  }
}