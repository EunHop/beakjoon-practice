package algorithm.basic.one.math.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드바흐 파티션 : 짝수 N을 두 소수의 합으로 나타내는 표현
 * 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 단, 두 소수의 순서만 다른 것은 같은 파티션이다.
 * 1. 1_000_000 까지의 소수를 구한다.
 * 2. 1 ~ N/2 까지 반복문을 돌리면서 i 도 소수고 N-i 도 소수이면 count++ 해준다.
 * 3. 1 은 당연히 소수가 아니므로 반복문을 하나 줄일 수 있다. 2 ~ n/2 까지.
 */
public class b_17103 {
  static int MAX_NUM = 1_000_000;
  // prime[2] = false, 소수
  static boolean[] prime = new boolean[MAX_NUM + 1];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    setPrime();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      int count = 0;
      // 1 은 당연히 소수가 아니므로 반복문을 하나 줄일 수 있다.
      for(int j=2; j<=N/2; j++) {
        // j 도 소수고 N-j 도 소수이면 count++
        if(!prime[j] && !prime[N-j]) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb.toString());
  }

  static void setPrime() {
    // 0 과 1은 소수가 아니다.
    prime[0] = true;
    prime[1] = true;
    for (int i = 2; i <= Math.sqrt(MAX_NUM); i++) {
      if (!prime[i]) {
        for (int j = i * i; j <= MAX_NUM; j += i) {
          prime[j] = true;
        }
      }
    }
  }
}
