import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] dist = new int[100001];

    Queue<Integer> queue = new LinkedList<>();
    Arrays.fill(dist, -1);
    dist[n] = 0;
    queue.offer(n);
    int result1 = 0;
    while (!queue.isEmpty()) {
      int cx = queue.poll();
      if (cx == k) {
        result1 = dist[cx];
        break;
      }
      int[] dx = { -1, 1, cx };
      for (int i = 0; i < 3; i++) {
        int nx = cx + dx[i];
        if (nx < 0 || nx > 100000)
          continue;
        if (dist[nx] != -1)
          continue;
        dist[nx] = dist[cx] + 1;
        queue.offer(nx);
      }
    }

    queue = new LinkedList<>();
    Arrays.fill(dist, -1);
    dist[n] = 0;
    queue.offer(n);
    int result2 = 1;
    while (!queue.isEmpty()) {
      int cx = queue.poll();
      int[] dx = { -1, 1, cx };
      for (int i = 0; i < 3; i++) {
        int nx = cx + dx[i];
        if (nx < 0 || nx > 100000)
          continue;
        if (nx == k) {
          if (dist[nx] == -1) {
            dist[nx] = dist[cx] + 1;
            continue;
          } else {
            if (dist[cx] + 1 <= result1) {
              result2++;
              continue;
            } else {
              System.out.println(result1);
              System.out.println(result2);
              return;
            }
          }
        }
        if (dist[nx] != -1 && dist[nx] < dist[cx] + 1)
          continue;
        dist[nx] = dist[cx] + 1;
        queue.offer(nx);
      }
    }
    System.out.println(result1);
    System.out.println(result2);
  }
}