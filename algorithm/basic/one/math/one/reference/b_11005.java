package algorithm.basic.one.math.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 진법 변환 2
 * 10진법 수 N이 주어진다. 이 수를 B 진법으로 바꿔 출력하는 프로그램을 작성하시오.
 * A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
 */
public class b_11005 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    StringBuilder sb = new StringBuilder();
    while(N>0) {
      int waste = N % B;
      if(waste >= 10) {
        // 아스키코드를 사용해서 A+1 => B 식으로 생각했다.
        // 계산된 숫자를 char 형으로 받아야하므로 전체 괄호를 char 타입으로 캐스팅한다.
        sb.append((char) ('A'+(waste-10)));
      } else {
        sb.append(waste);
      }
      N /= B;
    }
    System.out.println(sb.reverse().toString());
  }
}
