package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1932 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    for(int i=0; i<n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<=i; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 역삼각형으로 생각해야 한다.
    // dp[4] = {4, 5, 2, 6, 5};
    // dp[3][0] = arr[3][0]+Math.max(dp[4][0],dp[4][1]);
    // dp[3][1] = arr[3][1]+Math.max(dp[3][1],dp[3][2]);
    // dp[3][2] = arr[3][2]+Math.max(dp[3][2],dp[3][3]);
    // dp[3][3] = arr[3][3]+Math.max(dp[3][3],dp[3][4]);
    // ~~~
    int[][] dp = new int[n][n];
    for(int i=0; i<n; i++) {
      dp[n-1][i] = arr[n-1][i];
    }
    for(int i=n-2; i>=0; i--) {
      for(int j=0; j<=i; j++) {
        dp[i][j] = arr[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
      }
    }
    System.out.println(dp[0][0]);
  }
}
