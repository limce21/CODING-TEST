import java.io.*;
import java.util.StringTokenizer;

// 1번 도미노가 쓰러진다,
// k번 도미노가 쓰러지면 K+1번 도미노도 쓰러진다

/*
 * 1. 함수의 정의
 *    : 챗봇의 응답을 출력하는 함수 (앞에 cnt만큼 '____'를 반복한다.)
 * 2. base condition
 *    : cnt가 n일 때 답변을 출력하고 리턴한다.
 * 3. 재귀 식
 *    : 질문까지의 내용을 출력하고, cnt + 1 을 호출한다.
 */


public class Main {
  static int n;
  static StringBuilder sb = new StringBuilder();
  static String s = "____";

  static void func(int cnt) {
    sb.append(s.repeat(cnt) + "\"재귀함수가 뭔가요?\"\n");
    if (cnt == n) {
      sb.append(s.repeat(cnt) + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
    } else {
      sb.append(s.repeat(cnt) + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
      sb.append(s.repeat(cnt) + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
      sb.append(s.repeat(cnt) + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
      func(cnt + 1);
    }
    sb.append(s.repeat(cnt) + "라고 답변하였지.\n");
    return;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    func(0);
    System.out.println(sb);
    
  }
}

