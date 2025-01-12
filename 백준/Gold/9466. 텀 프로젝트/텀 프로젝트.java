import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[] graph;
  static int[] done;

  static int bfs(int x) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(x);
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(x);
    done[x] = 0;

    while (!queue.isEmpty()) {
      int cx = queue.poll();
      int nx = graph[cx];
      if (nx == cx) {
        for (int i = 0; i < arr.size(); i++) {
          done[arr.get(i)] = 0;
        }
        done[cx] = 1;
        return 1;
      }
      if (nx == x) {
        for (int i = 0; i < arr.size(); i++) {
          done[arr.get(i)] = 1;
        }
        return arr.size();
      }
      if (done[nx] != -1) {
        for (int i = 1; i < arr.size(); i++) {
          done[arr.get(i)] = -1;
        }
        return 0;
      }
      done[nx] = 0;
      queue.offer(nx);
      arr.add(nx);
    }
    for (int i = 1; i < arr.size(); i++) {
      done[arr.get(i)] = -1;
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for (int c=0; c < t; c++) {
      n = Integer.parseInt(br.readLine());
      graph = new int[n + 1];
      done = new int[n + 1];

      Arrays.fill(done, -1);
      int result = 0;
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        graph[i] = Integer.parseInt(st.nextToken());
      }
      
      for (int i = 1; i <= n; i++) {
        if (done[i] == -1) {
          int val = bfs(i);
          if (val > 0) {
            result += val;
          }
        }
      }
      System.out.println(n - result);
    }
  }
}