import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int f = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    int g = Integer.parseInt(st.nextToken());
    int u = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    int[] dist = new int[f+1];
    Arrays.fill(dist, -1);
    int[] dx = { u, -d };
    Queue<Integer> queue = new LinkedList<>();
    dist[s] = 0;
    queue.offer(s);

    while (!queue.isEmpty()) {
      int curr = queue.poll();
      if (curr == g) {
        System.out.println(dist[g]);
        return;
      }
      for (int i = 0; i < 2; i++) {
        int nx = curr + dx[i];
        if (nx <= 0 || nx > f)
          continue;
        if (dist[nx] != -1)
          continue;
        dist[nx] = dist[curr] + 1;
        queue.offer(nx);
      }
    }
    System.out.println("use the stairs");
  }
}