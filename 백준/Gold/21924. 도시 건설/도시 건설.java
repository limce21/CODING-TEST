import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[][] graph;
  static int[] parent;

  public static int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  public static void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x > y)
      parent[x] = y;
    else
      parent[y] = x;
  }


  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());
      graph = new int[m][3];
      long maxVal = 0;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        graph[i][0] = Integer.parseInt(st.nextToken());
        graph[i][1] = Integer.parseInt(st.nextToken());
        graph[i][2] = Integer.parseInt(st.nextToken());
        maxVal += graph[i][2];
      }
      Arrays.sort(graph, new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
          return o1[2] - o2[2];
        }
      });
      parent = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        parent[i] = i;
      }
      long answer = 0;
      for (int i = 0; i < m; i++) {
        if (find(graph[i][0]) != find(graph[i][1])) {
          union(graph[i][0], graph[i][1]);
          answer += graph[i][2];
          continue;
        }
      }
      for (int i = 1; i < n; i++) {
        if (find(i) != find(i+1)) {
          System.out.println(-1);
          return;
        }
      }
      System.out.println(maxVal - answer);
  }
}
