package algorithm.basic.one.data.structure.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_9093 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      // st에 토큰이 있을때까지 반복
      while (st.hasMoreTokens()) {
        // StringBuilder 를 생성해서 그 안에 단어(토큰)를 담고 .reverse() 로 단어를 뒤집는다.
        // 뒤집힌 단어를 sb.append 로 넣어준다.
        sb.append(new StringBuilder(st.nextToken()).reverse()).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}