import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
   
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Stack<int[]> stack = new Stack<int[]>();
    int[] result = new int[n];
    Arrays.fill(result, -1);
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty()) {
        int[] tmp = stack.peek();
        if (tmp[0] < arr[i]) {
          stack.pop();
          result[tmp[1]] = arr[i];
        } else {
          break;
        }
      }
      stack.add(new int[] { arr[i], i });
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(result[i] + " ");
    }
    System.out.println(sb);
  }
}
