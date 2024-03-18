package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1463 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N+1];  // 1부터 시작하므로 N을 담으려면 N+1이 되어야함
    // bottom-up 방식
    dp[0] = dp[1] = 0;
    for(int i=2; i<=N; i++) {
      dp[i] = dp[i-1]+1; // 먼저 1을 뺸 횟수 1번을 추가
      if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1); // 먼저 1을 뺸 dp[i]와 dp[i/2]에서 1을 뺀 횟수 중 작은 값 넣기
      if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1); // 먼저 1을 뺸 dp[i]와 dp[i/3]에서 1을 뺀 횟수 중 작은 값 넣기
    }
    System.out.println(dp[N]);
  }
}
