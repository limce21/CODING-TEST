import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static int[][] map;
  static int[][] cctv = new int[8][3];
  static int cnt = 0;
  static int result = Integer.MAX_VALUE;

  static HashMap<String, int[][]> hash = new HashMap<String, int[][]>();

  static void watch(int x, int y, int[] dir, int[][] tmp) {
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };


    for (int d = 0; d < dir.length; d++) {
      int nx = x;
      int ny = y;
      while (true) {
        nx += dx[dir[d]];
        ny += dy[dir[d]];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m)
          break;
        if (tmp[nx][ny] == 6)
          break;
        if (tmp[nx][ny] == 0) {
          tmp[nx][ny] = -1;
        }
      }
    }
  }

	private static int[][] getDeepCopiedOffice(int[][] office) {
		int[][] deepCopiedOffice = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				deepCopiedOffice[i][j] = office[i][j];
			}
		}
		
		return deepCopiedOffice;
	}

  static void search(int k, int[][] graph) {
    int[][] tmp = getDeepCopiedOffice(graph);
    if (k == cnt) {
      int tmpCnt = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          // System.out.print(tmp[i][j] + " ");
          if (graph[i][j] == 0) {
            tmpCnt++;
          }
        }
      }
      result = Math.min(result, tmpCnt);
      return;
    }

    int x = cctv[k][0];
    int y = cctv[k][1];
    int mode = cctv[k][2];

    int[][] dirArr = hash.get(Integer.toString(mode));
    for (int i = 0; i < dirArr.length; i++) {
      watch(x, y, dirArr[i], tmp);
      search(k + 1, tmp);
      tmp = getDeepCopiedOffice(graph);
    }

  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[][] arr1 = { { 0 }, { 1 }, { 2 }, { 3 } };
    int[][] arr2 = { { 0, 1 }, { 2, 3 } };
    int[][] arr3 = { { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };
    int[][] arr4 = { { 0, 1, 2 }, { 0, 1, 3 }, { 0, 2, 3 }, { 1, 2, 3 } };
    int[][] arr5 = { { 0, 1, 2, 3 } };
    hash.put("1", arr1);
    hash.put("2", arr2);
    hash.put("3", arr3);
    hash.put("4", arr4);
    hash.put("5", arr5);

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0 && map[i][j] != 6) {
          cctv[cnt][0] = i;
          cctv[cnt][1] = j;
          cctv[cnt][2] = map[i][j];
          cnt++;
        }
      }
    }
    search(0, map);
    System.out.println(result);
  }
}

