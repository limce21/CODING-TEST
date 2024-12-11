import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] T = new int[N + 1];
    int[] P = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }
    
    int[] dp = new int[N + 1];
    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= N; i++) {
      if (i + T[i] <= N+1) {
        dp[i] = P[i];
        for (int j = 1; j < i; j++) {
          if (j + T[j] <= i) {
            dp[i] = Math.max(dp[i], P[i] + dp[j]);
          }
        }
      }
      result = Math.max(result, dp[i]);
    }

    System.out.println(result);
  }
}

