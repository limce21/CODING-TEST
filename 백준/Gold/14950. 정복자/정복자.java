import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int t;
  static int[] parent;
  static int[][] graph;

  static public int find(int x) {
    if (parent[x] == x)
      return x;
    return parent[x] = find(parent[x]);
  }

  static public void union(int x, int y) {
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
      t = Integer.parseInt(st.nextToken());

      graph = new int[m][3];
      int fx = -1;
      int fw = 0;
      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        graph[i][0] = Integer.parseInt(st.nextToken());
        graph[i][1] = Integer.parseInt(st.nextToken());
        graph[i][2] = Integer.parseInt(st.nextToken());
        if (graph[i][0] == 1) {
          if (fx == -1) {
            fx = graph[i][1];
            fw = graph[i][2];
          } else if (fw > graph[i][2]) {
            fx = graph[i][1];
            fw = graph[i][2];
          }
        } else if (graph[i][1] == 1) {
          if (fx == -1) {
            fx = graph[i][0];
            fw = graph[i][2];
          } else if (fw > graph[i][2]) {
            fx = graph[i][0];
            fw = graph[i][2];
          }
        }
      }

      parent = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        parent[i] = i;
      }

      int answer = 0;
      union(1, fx);
      answer += fw;

      Comparator<int[]> comparator = new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2) {
          return Integer.compare(o1[2], o2[2]);
        }
      };

      Arrays.sort(graph, comparator);

      int cnt = 1;
      for (int i = 0; i < m; i++) {
        if ((graph[i][0] == 1 && graph[i][1] == fx) || (graph[i][0] == fx && graph[i][1] == 1))
          continue;
        if (find(graph[i][0]) != find(graph[i][1])) {
          union(graph[i][0], graph[i][1]);
          answer += (graph[i][2] + (t * cnt));
          cnt++;
          continue;
        }
      }
      System.out.println(answer);
  }
}

