import java.io.*;
import java.util.*;

public class Main {
  static Set<String> set = new HashSet<>();

  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j <= s.length(); j++) {
          set.add(s.substring(i, j));
        }
      }
      System.out.println(set.size());
  }
}
