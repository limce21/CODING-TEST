import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int[] visitor = new int[n];
      
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        visitor[i] = Integer.parseInt(st.nextToken());
      }

      int max = 0;
      int end = 0;
      int cnt = 0;
      int sum = 0;
      for (int start = 0; start < n; start++) {
        while (end < n && end - start < x) {
          sum += visitor[end];
          end++;
        }
        
        if (end - start < x)
          break;
        
        if (sum > max) {
          max = sum;
          cnt = 1;
        } else if (sum == max) {
          cnt++;
        }
        sum -= visitor[start];
      }
      if (max == 0) {
        System.out.println("SAD");
      } else {
        System.out.println(max);
        System.out.println(cnt);
      }
  }
}