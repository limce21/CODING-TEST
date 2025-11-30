import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int q;
  static ArrayList<ArrayList<int[]>> usado = new ArrayList<>();
  static boolean[] visited = new boolean[n + 1];
  static Queue<Integer> queue = new LinkedList<>();

  public static int bfs(int x, int k) {
    int answer = 0;
    Arrays.fill(visited, false);
    queue.clear();
    queue.offer(x);
    visited[x] = true;
    while (!queue.isEmpty()) {
      int cnode = queue.poll();
      for (int i = 0; i < usado.get(cnode).size(); i++) {
        int[] nx = usado.get(cnode).get(i);
        int node = nx[0];
        int weight = nx[1];
        if (!visited[node] && weight >= k) {
          visited[node] = true;
          queue.offer(node);
          answer++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      q = Integer.parseInt(st.nextToken());
      visited = new boolean[n + 1];
      for(int i=0; i<=n; i++){
        usado.add(new ArrayList<>());
      }

      for (int i = 0; i < n - 1; i++) {
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        usado.get(p).add(new int[] { q, r });
        usado.get(q).add(new int[] { p, r });
      }


      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < q; i++) {
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int answer = bfs(v, k);
        sb.append(answer + "\n");
      }
      System.out.println(sb);
  }
}

