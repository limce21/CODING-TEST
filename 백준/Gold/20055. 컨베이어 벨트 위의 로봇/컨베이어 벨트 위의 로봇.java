import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int k;
  static int[] belt;
  static int[] robot;
  static int result = 0;

  public static void load() {
    if (belt[0] > 0 && robot[0] == 0) { // 내구도가 1이상이고 자리에 로봇이 없다면
      robot[0] = 1;
      belt[0] -= 1;
      if(belt[0] <= 0) result++;
    }
  }

  public static void rotate() {
    int[] tmp = new int[2 * n];
    for (int i = 1; i < 2 * n; i++) {
      tmp[i] = belt[i - 1];
    }
    tmp[0] = belt[2 * n - 1];
    belt = tmp;

    tmp = new int[2 * n];
    for (int i = 1; i < 2 * n; i++) {
      tmp[i] = robot[i - 1];
    }
    tmp[0] = robot[2 * n - 1];
    robot = tmp;
  }
  
  public static void move(int idx) {
    if (belt[idx + 1] > 0 && robot[idx + 1] == 0) {
      robot[idx] = 0;
      robot[idx + 1] = 1;
      belt[idx + 1] -= 1;
      if (belt[idx + 1] <= 0)
        result++;
      if (idx + 1 == n - 1) {
        robot[n - 1] = 0;
      }
    }
  }

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      k = Integer.parseInt(st.nextToken());

      belt = new int[2 * n];
      robot = new int[2 * n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < 2 * n; i++) {
        belt[i] = Integer.parseInt(st.nextToken());
      }
      
      int level = 0;
      while (result < k) {
        level++;

        rotate();
        if (robot[n - 1] == 1)
          robot[n - 1] = 0;
        for (int i = 2*n-1; i >= 0; i--) {
          if (robot[i] == 1) {
            move(i);
          }
        }
        load();

        if (result >= k) {
          System.out.println(level);
          return;
        }
      }
  }
}