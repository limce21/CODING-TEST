import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[n];
    int result = Integer.MIN_VALUE;
    StringTokenizer st = new StringTokenizer(br.readLine());
    dp[0] = Integer.parseInt(st.nextToken());
    result = Math.max(result, dp[0]);
    for (int i = 1; i < n; i++) {
      int val = Integer.parseInt(st.nextToken());
      dp[i] = Math.max(dp[i - 1] + val, val);
      result = Math.max(result, dp[i]);
    }

    System.out.println(result);
  }
}

