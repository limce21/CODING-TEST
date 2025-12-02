import java.io.*;
import java.util.*;

public class Main {
  static int[][] gear = new int[4][8];
  static Queue<int[]> queue = new LinkedList<>();
  static boolean[] visited = new boolean[4];
  static int[] dx = { -1, 1 };
  static int[] dir = new int[4];

  static public void rotate(int n, int d) {
    int[] tmp = new int[8];
    if (d == -1) { // 반시계
      for (int i = 0; i < 7; i++) {
        tmp[i] = gear[n][i + 1];
      }
      tmp[7] = gear[n][0];
    } else { // 시계
      for (int i = 1; i < 8; i++) {
        tmp[i] = gear[n][i - 1];
      }
      tmp[0] = gear[n][7];
    }
    gear[n] = tmp;
  }

  static public void visit(int idx, int d) {
    dir[idx] = d;
    visited = new boolean[4];
    queue.clear();
    queue.offer(new int[] { idx, d });
    visited[idx] = true;
    while (!queue.isEmpty()) {
      int[] ci = queue.poll();
      for (int i = 0; i < 2; i++) {
        int ni = ci[0] + dx[i];
        
        if (ni < 0 || ni >= 4)
          continue;
        if (visited[ni])
          continue;
        if ((i == 0 && (gear[ci[0]][6] != gear[ni][2])) || (i == 1 && gear[ci[0]][2] != gear[ni][6])) {
          visited[ni] = true;
          dir[ni] = -ci[1];
          queue.offer(new int[] { ni, -ci[1] });
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (int i = 0; i < 4; i++) {
        String s = br.readLine();
        for (int j = 0; j < 8; j++) {
          gear[i][j] = s.charAt(j) - '0';
        }
      }

      StringTokenizer st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      for (int a = 0; a < k; a++) {
        Arrays.fill(dir, 0);
        st = new StringTokenizer(br.readLine());
        int idx = Integer.parseInt(st.nextToken()) - 1;
        int d = Integer.parseInt(st.nextToken());
        visit(idx, d);
        for (int i = 0; i < 4; i++) {
          if (dir[i] == 0)
            continue;
          rotate(i, dir[i]);
        }
      }

      int answer = 0;
      for (int i = 0; i < 4; i++) {
        if (gear[i][0] == 1) {
          answer = answer + (int)Math.pow(2, i);
        }
      }
      System.out.println(answer);
  }
}
