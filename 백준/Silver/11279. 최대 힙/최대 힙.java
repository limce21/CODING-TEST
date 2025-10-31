import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      if (x == 0) {
        if (!pq.isEmpty()) {
          System.out.println(pq.poll());
        } else {
          System.out.println(0);
        }
        
      } else {
        pq.offer(x);
      }
    }
  }
}
