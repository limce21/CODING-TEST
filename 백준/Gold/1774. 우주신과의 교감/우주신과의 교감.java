import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static double[][] graph;
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
      int[][] node = new int[n+1][2];
      for (int i = 1; i <= n; i++) {
        st = new StringTokenizer(br.readLine());
        node[i][0] = Integer.parseInt(st.nextToken());
        node[i][1] = Integer.parseInt(st.nextToken());
      }
      int cnt = (n * (n-1)) / 2;
      double[][] graph = new double[cnt+m][3];
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        graph[i][0] = Integer.parseInt(st.nextToken());
        graph[i][1] = Integer.parseInt(st.nextToken());
        graph[i][2] = 0;
      }
      int c = m;
      for (int i = 1; i <= n; i++) {
        int x1 = node[i][0];
        int y1 = node[i][1];
        for (int j = i + 1; j <= n; j++) {
          int x2 = node[j][0];
          int y2 = node[j][1];
          graph[c][0] = i;
          graph[c][1] = j;
          graph[c][2] = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
          c++;
        }
      }
      Arrays.sort(graph, new Comparator<double[]>(){
        @Override
        public int compare(double[] o1, double[] o2){
          return Double.compare(o1[2], o2[2]);
        }
      });
      double answer = 0;
      parent = new int[n+1];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
      for (int i = 0; i < cnt; i++) {
        if (find((int) graph[i][0]) != find((int) graph[i][1])) {
          union((int) graph[i][0], (int) graph[i][1]);
          answer += graph[i][2];
          continue;
        }
      }
      System.out.println(String.format("%.2f", answer));
  }
}
