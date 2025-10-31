import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while(!stack.isEmpty() && stack.peek() <= arr[i]){
        stack.pop();
      }
      result += stack.size();
      stack.push(arr[i]);
    }

    System.out.println(result);
  }
}
