package algorithm.basic.one.math.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 진법 변환
 * B진법 수 N이 주어진다. 이 수를 10진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */
public class b_2745 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String N = st.nextToken();
    int B = Integer.parseInt(st.nextToken());
    // StringBuilder 를 사용해 문자열을 뒤집는 방법
    String reversedN = new StringBuilder(N).reverse().toString();
    int result = 0;
    for (int i = 0; i < reversedN.length(); i++) {
      if (reversedN.charAt(i) >= 'A') {
        // 아스키코드를 생각하면서 숫자로 변환시켜 계산한다.
        result += (reversedN.charAt(i) - 'A' + 10) * (int) Math.pow(B, i);
      } else {
        result += (reversedN.charAt(i) - '0') * (int) Math.pow(B, i);
      }
    }
    System.out.println(result);
  }
}
