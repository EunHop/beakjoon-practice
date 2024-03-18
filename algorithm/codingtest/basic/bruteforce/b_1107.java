package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1107 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    // 0~9, +, -
    // 사용 불가능한 버튼을 true 처리
    boolean[] broken = new boolean[10];
    if(M>0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i=0; i<M; i++) {
        // broken[Integer.parseInt(st.nextToken())] 으로 바로 넣어서 처리할 경우 백준에서 NullPointer 오류 발생
        int num = Integer.parseInt(st.nextToken());
        broken[num] = true;
      }
    }
    // +, -로만 이동한 횟수
    // N이 100보다 작아서 음수가 나올 수도 있으니 절대값 처리
    int result = Math.abs(N-100);
    // 완전 탐색
    // N이 500000이므로 999999까지 탐색
    for(int j=0; j<1000000; j++) {
      String str = Integer.toString(j);
      boolean isBreak = false;
      for(int k=0; k<str.length(); k++) {
        // 사용 불가능한 버튼이 true 이므로 사용 불가능하면 빠져나온다.
        // str.charAt(k)-'0' 은 아스키코드 값 빼서 배열의 인덱스에 맞춰주는 것
        if(broken[str.charAt(k)-'0']) {
          isBreak = true;
          break;
        }
      }
      if(!isBreak) {
        // min값이 for문을 돌며 계속 바뀜, 하지만 result엔 어차피 최소값 들어감.
        int min = Math.abs(N - j) + str.length();
        // Math.min() 둘중 작은 값 리턴 순서 상관없음
        result = Math.min(min, result);
      }
    }
    System.out.println(result);
  }
}
