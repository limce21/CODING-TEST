import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      StringBuilder sb = new StringBuilder();
      sb.append('<');

      Queue<Integer> queue = new LinkedList<Integer>();
      for (int i = 1; i <= n; i++) {
        queue.offer(i);
      }
      int cnt = 1;
      int result = 0;
      while (!queue.isEmpty()) {
        int var = queue.poll();
        if (cnt == k) {
          cnt = 1;
          if (result == n-1) {
            sb.append(var + ">");
            break;
          } else {
            result++;
            sb.append(var + ", ");
          }
        } else {
          cnt++;
          queue.offer(var);
        }
      }

      System.out.println(sb);
  }
}


