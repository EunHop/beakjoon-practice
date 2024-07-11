package algorithm.basic.one.dynamic.programming.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스티커
 *  2n개의 스티커 중에서 점수의 합이 최대가 되면서 서로 변을 공유 하지 않는 스티커 집합을 구해야 한다.
 * n (1 ≤ n ≤ 100,000)
 */
public class b_1309 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++) {
      int n = Integer.parseInt(br.readLine());
      int[][] stickers = new int[2][n];
      int[][] dp = new int[2][n];

      // 스티커 배열 입력 처리
      for(int j=0; j<2; j++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int k=0; k<n; k++) {
          stickers[j][k] = Integer.parseInt(st.nextToken());
        }
      }

      // 스티커 길이가 1일 경우.
      dp[0][0] = stickers[0][0];
      dp[1][0] = stickers[1][0];
      if(n==1)  {
        sb.append(Math.max(dp[0][0], dp[1][0])).append("\n");
        continue;
      }

      // 스티커 길이가 2일 경우.
      // 건너서 생각할 필요 없음.
      dp[0][1] = dp[1][0] + stickers[0][1];
      dp[1][1] = dp[0][0] + stickers[1][1];
      if(n==2) {
        sb.append(Math.max(dp[0][1], dp[1][1])).append("\n");
        continue;
      }

      // 스티커 길이가 3 이상일 경우.
      for(int j=2; j<n; j++) {
        dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2]) + stickers[0][j];
        dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2]) + stickers[1][j];
      }
      sb.append(Math.max(dp[0][n-1], dp[1][n-1])).append("\n");
    }
    System.out.println(sb.toString());
  }
}
