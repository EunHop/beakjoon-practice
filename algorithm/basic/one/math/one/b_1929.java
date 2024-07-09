package algorithm.basic.one.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1929 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    // 소수 = false, 소수아님 = true;
    boolean[] prime = new boolean[1_000_001];
    prime[0]=prime[1]=true;
    // 에라토스테네스의 체 알고리즘
    // 최대 크기의 제곱근 만큼 돌려야 배수를 돌며 1,000,000까지 들어간다.
    for(int i=2; i<=Math.sqrt(1_000_000); i++) {
      // 소수가 아님으로 판명났으면 이전 반복에서 배수마다 소수가 아님으로 처리했으니 또 처리할 필요 없음
      // ex) 2 x 32 = 4 x 16 = 8 x 8
      if(prime[i]) continue;
      // 배수는 소수가 아님
      for(int j=i*i; j<=1_000_000; j+=i) {
        prime[j] = true;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=M; i<=N; i++) {
      if(!prime[i]) {
        sb.append(i).append("\n");
      }
    }
    System.out.print(sb);
  }
}
