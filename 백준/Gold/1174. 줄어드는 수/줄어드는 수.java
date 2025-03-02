import java.io.*;
import java.util.*;

public class Main {
  static Queue<long[]> queue = new LinkedList<>();
  static LinkedList<Long> arr = new LinkedList<Long>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < 10; i++) {
      arr.add((long)i);
      queue.offer(new long[] { i, i });
    }
    
    while (!queue.isEmpty()) {
      long[] cur = queue.poll();
      long idx = cur[0];
      long last = cur[1];
      for (int i = 0; i < last; i++) {
        String val = Long.toString(idx) + Long.toString(i);
        queue.offer(new long[] { Long.parseLong(val), i });
        arr.add(Long.parseLong(val));
      }
    }
    
    if (n-1 >= arr.size()) {
      System.out.println(-1);
    } else {
      System.out.println(arr.get(n-1));
    }
  }
}