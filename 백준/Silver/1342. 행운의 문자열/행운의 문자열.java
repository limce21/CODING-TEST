import java.io.*;
import java.util.*;

public class Main {
  static int[] number;
  static int[] arr;
  static int[] isUsed = new int[26];
  static int size;
  static int result = 0;

  static void search(int k) {
    if (k == size) {
      result++;
      return;
    }
    for (int i = 0; i < 26; i++) {
      if (isUsed[i] == 0)
        continue;
      if (k == 0) {
        isUsed[i] -= 1;
        arr[k] = i;
        search(k + 1);
        isUsed[i] += 1;
      } else if (arr[k - 1] != i) {
        isUsed[i] -= 1;
        arr[k] = i;
        search(k + 1);
        isUsed[i] += 1;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    size = s.length();
    number = new int[size];
    arr = new int[size];
    for (int i = 0; i < size; i++) {
      int idx = s.charAt(i) - 'a';
      isUsed[idx] = isUsed[idx] + 1;
    }

    search(0);
    System.out.println(result);
  }
}

