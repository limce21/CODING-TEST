import java.io.*;
import java.util.*;

public class Main {
  static long calc(long a, long b, long c) {
    if (b == 1)
      return a % c;
    long val = calc(a, b / 2, c);
    val = val * val % c;
    if (b % 2 == 0)
      return val;
    return val * a % c;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    long result = calc(a, b, c);
    System.out.println(result);
  }
}