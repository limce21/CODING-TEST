import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int m;
  static boolean[] wall;

  static void breakWall(int x, int y){
    for(int i=x; i<y; i++){
      wall[i] = true;
    }
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());
    wall = new boolean[n+1];

    for (int t = 0; t < m; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      breakWall(x, y);
    }

    int result = 0;
    for (int i = 0; i < n+1; i++) {
      if(!wall[i]) result++;
    }
    System.out.println(result - 1);
  }
}
