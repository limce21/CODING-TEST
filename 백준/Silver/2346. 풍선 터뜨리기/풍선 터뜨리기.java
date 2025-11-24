import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int[] bals = new int[n + 1];

      Deque<Integer> deque = new ArrayDeque<Integer>();
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i <= n; i++) {
        bals[i] = Integer.parseInt(st.nextToken());
        deque.offer(i);
      }

      boolean isRight = true;
      int var = 0;
      while (!deque.isEmpty()) {
        if (isRight) {
          var = deque.pollFirst();
        } else {
          var = deque.pollLast();
        }
        sb.append(var + " ");
        if (deque.isEmpty())
          break;
        int k = bals[var];
        if (k > 0) {
          isRight = true;
          while (k > 1) {
            k--;
            deque.offerLast(deque.pollFirst());
          }
        } else {
          isRight = false;
          while (k < -1) {
            k++;
            deque.offerFirst(deque.pollLast());
          }
        }
      }
      System.out.println(sb);
  }
}
