import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[] photo;
  static int recom;
  static int[] students = new int[101];
  static int[] isOld = new int[101];


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    photo = new int[n];
    recom = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int cnt = 0;
    for (int c = 0; c < recom; c++) {
      int i = Integer.parseInt(st.nextToken());

      if (students[i] > 0) {
        students[i] = students[i] + 1;
      } else {
        if (cnt < n) {
          students[i] = 1;
          cnt++;
          isOld[i] = c;
        } else {
          int min = Integer.MAX_VALUE;
          int delStu = 0;
          for (int j = 1; j <= 100; j++) {
            if (students[j] == 0)
              continue;
            if (min == students[j]) {
              if (isOld[j] < isOld[delStu]) {
                delStu = j;
              }
            } else if (min > students[j]) {
              min = students[j];
              delStu = j;
            }
          }
          students[i] = 1;
          isOld[i] = c;
          students[delStu] = 0;
          isOld[delStu] = 0;

        }
      }
    }
    for (int i = 1; i <= 100; i++) {
      if (students[i] > 0) {
        System.out.print(i + " ");
      }
    }
  }
}


