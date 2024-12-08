import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] dp = new int[n+1];
    st = new StringTokenizer(br.readLine());
    dp[1] = Integer.parseInt(st.nextToken());
    
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + Integer.parseInt(st.nextToken());
    }
    
    for (int k = 0; k < m; k++) {
      st = new StringTokenizer(br.readLine());
      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());
      int result = dp[j] - dp[i - 1];
      System.out.println(result);
    }
  }
}