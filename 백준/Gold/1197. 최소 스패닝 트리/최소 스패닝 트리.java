import java.io.*;
import java.util.*;

public class Main {
  static int v;
  static int e;
  static int[] parent;
  static int[][] graph;

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
      v = Integer.parseInt(st.nextToken());
      e = Integer.parseInt(st.nextToken());
      graph = new int[e][3];

      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(br.readLine());
        graph[i][0] = Integer.parseInt(st.nextToken());
        graph[i][1] = Integer.parseInt(st.nextToken());
        graph[i][2] = Integer.parseInt(st.nextToken());
      }

      parent = new int[v+1];
      for (int i = 1; i <= v; i++) {
        parent[i] = i;
      }

      Arrays.sort(graph, new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
          return o1[2] - o2[2];
        }
      });

      int answer = 0;
      for (int i = 0; i < e; i++) {
        if (find(graph[i][0]) != find(graph[i][1])) {
          union(graph[i][0], graph[i][1]);
          answer += graph[i][2];
          continue;
        }
      }
      System.out.println(answer);
  }
}

