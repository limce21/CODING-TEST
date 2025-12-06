import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[] s = new int[n];
      ArrayList<Integer> delArr = new ArrayList<>();
      
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        s[i] = Integer.parseInt(st.nextToken());
      }

      int max = 0;
      int start = 0;
      int end = 0;
      int cnt = 0;
      int nK = 0;
      while (end < n) {
        if (nK < k) {
          if (s[end] % 2 == 0) {
            cnt++;
            end++;
            max = Math.max(max, cnt - nK);
            continue;
          }
          end++;
          cnt++;
          nK++;
          max = Math.max(max, cnt - nK);
          continue;
        }
        if (nK == k) {
          if (s[end] % 2 == 0) {
            cnt++;
            end++;
            max = Math.max(max, cnt - nK);
            continue;
          }
          while (s[start] % 2 == 0) {
            cnt--;
            start++;
          }
          cnt--;
          nK--;
          start++;
          max = Math.max(max, cnt - nK);
        }
        
      }
      System.out.println(max);
  }
}