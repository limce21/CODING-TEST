import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
  static int[] group = new int[20000];
  static String answer = "";

  static boolean bfs(int node, int[] group) {
  Queue<Integer> queue = new LinkedList<>();
  queue.add(node);
  group[node] = 1;
  while (!queue.isEmpty()) {
    int root = queue.poll();
    for (int i = 0; i < edges.get(root).size(); i++) {
      int val = edges.get(root).get(i);
      if (group[root] == group[val]) {
        answer = "NO";
        return false;
      }
      if (group[val] == 0) {
        group[val] = -group[root];
        queue.offer(val);
      }
    }
  }
  return true;
}

  public static void main(String[] args) throws IOException {
    // 입력값
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    for (int t = 0; t < k; t++) {
      answer = "YES";
      st = new StringTokenizer(br.readLine());
      int v = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      Arrays.fill(group, 0);

      edges.clear();
      for (int i = 0; i < v; i++) {
        edges.add(new ArrayList<>());
      }

      for (int i = 0; i < e; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        edges.get(a - 1).add(b - 1);
        edges.get(b - 1).add(a - 1);
      }
      for (int i = 0; i < v; i++) {
        if (group[i] == 0) {
          if (!bfs(i, group)) {
            break;
          }
        }
      }
      System.out.println(answer);
    }
  }
}