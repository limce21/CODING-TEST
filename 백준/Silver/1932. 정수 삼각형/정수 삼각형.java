import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n][n];

    dp[0][0] = Integer.parseInt(br.readLine());
    for(int i=1; i<n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      dp[i][0] = dp[i-1][0] + Integer.parseInt(st.nextToken());
      for(int j=1; j<i; j++){
        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + Integer.parseInt(st.nextToken());
      }
      dp[i][i] = dp[i-1][i-1] + Integer.parseInt(st.nextToken());
    }
    
    int result = 0;
    for (int i = 0; i < n; i++) {
      result = Math.max(result, dp[n-1][i]);
    }

    System.out.println(result);
  }
}