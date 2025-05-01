import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>(5);

    for (int i = 0; i < n; i++) {
      arr.add(new ArrayList<>());
    }

    int results[] = new int[n];
    
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr.get(a - 1).add(b - 1);
      arr.get(b - 1).add(a - 1);
    }

    for (int k = 0; k < n; k++) {
      Queue<Integer> q = new LinkedList<>();
      int[] bacon = new int[n];
      boolean[] visited = new boolean[n];
      visited[k] = true;
      q.offer(k);
      while (!q.isEmpty()) {
        int root = q.poll();
        for (int i = 0; i < arr.get(root).size(); i++) {
          int val = arr.get(root).get(i);
          if (!visited[val]) {
            bacon[val] = bacon[root] + 1;
            visited[val] = true;
            q.offer(val);
          }
        }
      }
      for (int i = 0; i < n; i++) {
        results[k] += bacon[i];
      }
    }
    int result = results[0];
    int answer = 0;
    for (int i = 1; i < n; i++) {
      if (results[i] < result) {
        result = results[i];
        answer = i;
      }
    }
    System.out.println(answer+1);
  }
}
