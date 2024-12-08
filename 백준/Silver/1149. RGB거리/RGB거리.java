import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] costs = new int[n + 1][3];

    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int length = st.countTokens();
      for (int j = 0; j < length; j++) {
        costs[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int[][] dp = new int[n + 1][3];
    dp[1][0] = costs[1][0];
    dp[1][1] = costs[1][1];
    dp[1][2] = costs[1][2];

    for (int i = 2; i <= n; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
    }

    int result = Math.min(dp[n][0], dp[n][1]);
    result = Math.min(result, dp[n][2]);

    System.out.println(result);
  }
}