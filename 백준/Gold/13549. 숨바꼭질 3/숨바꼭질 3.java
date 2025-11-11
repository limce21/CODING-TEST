import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] graph = new int[100001];
    Arrays.fill(graph, -1);
    
    int[] dx = { -1, 1 };
    Queue<Integer> queue = new LinkedList<>();
    graph[n] = 0;
    queue.offer(n);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if (cur == k) {
        System.out.println(graph[cur]);
        return;
      }
      if (2 * cur >= 0 && 2 * cur <= 100000 && graph[2 * cur] < 0) {
        graph[2 * cur] = graph[cur];
        queue.offer(2 * cur);
      }

      for (int i = 0; i < 2; i++) {
        int nx = cur + dx[i];
        if (nx < 0 || nx > 100000)
          continue;
        if (graph[nx] >= 0)
          continue;
        graph[nx] = graph[cur] + 1;
        queue.offer(nx);
      }
    }
  }
}
