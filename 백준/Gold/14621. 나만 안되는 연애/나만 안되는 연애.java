import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[][] graph;
  static int[] parent;

  public static int find(int x) {
    if (parent[x] == x)
      return x;
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
      char[] sex = new char[n + 1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
        sex[i] = st.nextToken().charAt(0);
      }
      ArrayList<int[]> graph = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        if (sex[u] != sex[v]) {
          graph.add(new int[] { u, v, d });
        }
      }
      graph.sort(new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
          return Integer.compare(o1[2], o2[2]);
        }
      });
      parent = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        parent[i] = i;
      }

      int answer = 0;
      for (int i = 0; i < graph.size(); i++) {
        if (find(graph.get(i)[0]) != find(graph.get(i)[1])) {
          union(graph.get(i)[0], graph.get(i)[1]);
          answer += graph.get(i)[2];
          continue;
        }
      }

      for (int i = 1; i < n; i++) {
        if (find(i) != find(i + 1)) {
          System.out.println(-1);
          return;
        }
      }
      System.out.println(answer);
  }
}
