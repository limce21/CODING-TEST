import java.io.*;
import java.util.*;

public class Main {
  static int[][] graph;
  static StringBuilder sb = new StringBuilder();

  public static void dfs(int c, boolean[] visited) {
    sb.append(c + " ");
    visited[c] = true;
    for (int i = 1; i < graph[c].length; i++) {
      if (graph[c][i] == 1 && !visited[i]) {
        dfs(i, visited);
      }
    }
  }
  
  public static void bfs(int c, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(c);

    while(!queue.isEmpty()){
      int nc = queue.poll();
      sb.append(nc + " ");
      visited[nc] = true;
      for (int i = 1; i < graph[nc].length; i++) {
        if (graph[nc][i] == 1 && !visited[i]) {
          visited[i] = true;
          queue.offer(i);
        }
      }
    }
    
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    graph = new int[n + 1][n + 1];

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      graph[a][b] = 1;
      graph[b][a] = 1;
    }

    dfs(k, new boolean[n + 1]);
    sb.append("\n");
    bfs(k, new boolean[n + 1]);
    System.out.println(sb);
  }
}