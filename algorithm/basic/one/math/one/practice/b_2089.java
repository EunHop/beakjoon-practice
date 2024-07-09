package algorithm.basic.one.math.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2089 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    // num = 0 일때는 예외로 처리
    if(num == 0) {
      sb.append("0");
    }
    while(num!=0) {
      int reminder = num % -2;
      num = num / -2;
      // reminder 가 -1 이면 1로 바꿔주고 num 도 1 더해준다.
      // ex) -3 = -2 * 1 + -1 ==> -3 = -2 * 2 + 1
      if(reminder < 0) {
        reminder += 2;
        num += 1;
      }
      sb.append(reminder);
    }
    System.out.println(sb.reverse().toString());
  }
}
