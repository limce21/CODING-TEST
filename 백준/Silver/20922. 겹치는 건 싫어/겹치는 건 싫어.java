import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[] arr = new int[n];

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }


      int end = 0;
      int[] cnt = new int[100001];
      int len = 0;
      int max = 0;
      for (int start = 0; start < n; start++) {
        while (end < n && cnt[arr[end]] < k) {
          cnt[arr[end]] += 1;
          end++;
          len++;
        }

        if (end == n) {
          max = Math.max(max, len);
          break;
        }

        max = Math.max(max, len);
        len--;
        cnt[arr[start]] -= 1;

      }
      System.out.println(max);
  }
}