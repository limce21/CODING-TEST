import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    
    int[] graph = new int[200001];
    Arrays.fill(graph, -1);

    Queue<Integer> queue = new LinkedList<>();
    graph[n] = 0;
    queue.offer(n);

    while (!queue.isEmpty()) {
      int curr = queue.poll();

      if (curr == k) {
        System.out.println(graph[curr]);
        return;
      }

      int[] dx = { -1, 1, curr };
      for (int i = 0; i < 3; i++) {
        int nx = curr + dx[i];
        if (nx < 0 || nx > 200000)
          continue;
        if (graph[nx] != -1)
          continue;
        graph[nx] = graph[curr] + 1;
        queue.offer(nx);
      }
    }
  }
}