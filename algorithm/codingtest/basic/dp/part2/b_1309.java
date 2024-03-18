package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1309 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[N+1][3];
    dp[1][0] = 1;
    dp[1][1] = 1;
    dp[1][2] = 1;
    // 사자가 N번째 칸에 없을 때, 사자는 N-1번째 칸에 없거나 왼쪽이나 오른쪽에 있어야 합니다.
    //  dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
    // 사자가 N번째 왼쪽 칸에 있을 때, 사자는 N-1번쨰 칸에 없거나 오른쪽 칸에 있어야 합니다.
    //  dp[i][1] = dp[i-1][0] + dp[i-1][2]
    // 사자가 N번째 오른쪽 칸에 있을 때, 사자는 N-1번쨰 칸에 없거나 왼쪽 칸에 있어야 합니다.
    //  dp[i][2] = dp[i-1][0] + dp[i-1][1]
    for(int i=2; i<=N; i++) {
      dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
      dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
      dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
    }
    System.out.println((dp[N][0]+dp[N][1]+dp[N][2]) % 9901);
  }
}
