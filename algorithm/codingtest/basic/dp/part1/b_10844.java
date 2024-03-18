package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_10844 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    // [자릿수][시작하는 숫자] ex) dp[3][5] = dp[2][4]+dp[2][6];
    long[][] dp = new long[N + 1][10];
    long mod = 1_000_000_000;
    // 1의 자리는 모두 1개씩이다.
    for (int i = 1; i <= 9; i++) {
      dp[1][i] = 1;
    }
    for (int i = 2; i <= N; i++) {
      for (int j = 0; j <= 9; j++) {
        if (j == 0) {
          dp[i][j] = dp[i - 1][j + 1] % mod;
        } else if (j == 9) {
          dp[i][j] = dp[i - 1][j - 1] % mod;
        } else {
          dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
        }
      }
    }
    long sum = 0;
    for(int i=0; i<=9; i++) {
      sum+= dp[N][i];
    }
    System.out.println(sum % mod);
  }
}
