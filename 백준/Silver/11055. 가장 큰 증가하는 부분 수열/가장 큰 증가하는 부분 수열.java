import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];
    int result = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      dp[i] = A[i];
      for(int j=0; j<i; j++){
        if(A[i] > A[j]){
          dp[i] = Math.max(dp[i], dp[j] + A[i]);
        }
      }
      result = Math.max(result, dp[i]);
    }
    
    System.out.println(result);
  }
}