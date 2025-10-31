import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
      @Override
      public int compare(int[] arr1, int[] arr2) {
        if (arr1[0] == arr2[0])
          return arr1[1] - arr2[1];
        else
          return arr1[0] - arr2[0];
      }
    });
    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      if (x == 0) {
        if (pq.isEmpty()) {
          System.out.println(0);
        } else {
          int[] pk = pq.poll();
          System.out.println(pk[1]);
        }
        
      } else {
        pq.offer(new int[] {Math.abs(x), x});
      }
    }
  }
}
