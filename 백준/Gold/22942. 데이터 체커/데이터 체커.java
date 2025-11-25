import java.io.*;
import java.util.*;

public class Main {
  static boolean flag = false;
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      
      PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
        @Override
        public int compare(int[] a, int[] b){
          if(a[1] == b[1]) {
            flag = true;
          }
          return a[1] - b[1];
        }
      });

      for(int i=0; i<n; i++){
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        pq.offer(new int[] {i, x-r});
        pq.offer(new int[] {i, x+r});
      }

      if(flag) {
        System.out.println("NO");
        return;
      }

      Stack<Integer> stack = new Stack<>();
      while(!pq.isEmpty()){
        int[] cur = pq.poll();
        if(stack.isEmpty()){
          stack.push(cur[0]);
        } else {
          if(stack.peek() == cur[0]){
            stack.pop();
          } else {
            stack.push(cur[0]);
          }
        }
      }
      if (stack.isEmpty()) {
          System.out.println("YES");
      } else {
          System.out.println("NO");
      }
  }
}
