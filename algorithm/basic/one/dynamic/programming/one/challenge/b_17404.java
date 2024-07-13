package algorithm.basic.one.dynamic.programming.one.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * RGB 거리 2
 * RGB거리에는 집이 N개 있다.
 * 집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
 * - 1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
 * - N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
 * - i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
 */
public class b_17404 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] cost = new int[N][3];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int result = Integer.MAX_VALUE;
    // 첫번째 집 R, G, B 선택에 의한 반복문
    for (int i = 0; i < 3; i++) {
      int[][] dp = new int[N][3];
      // 첫번째 집 색상 선택
      for (int j = 0; j < 3; j++) {
        if (j == i) dp[0][j] = cost[0][j];
        else dp[0][j] = 10000; // // 첫 번째 집의 다른 색은 들어올 수 있는 비용보다 큰 값으로 설정하여 선택되지 않도록
      }
      // 현재 위치의 합 = 다른 색상이면서 이전까지의 cost 합 중에 작은 값 + 현재 위치의 색상
      for (int j = 1; j < N; j++) {
        dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
        dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
        dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
      }
      // N번 집의 색과 첫번째 집의 색이 같지 않은 비용의 합 중에 최소비용
      for (int j = 0; j < 3; j++) {
        if (j != i) result = Math.min(result, dp[N - 1][j]);
      }
    }
    System.out.println(result);
  }
}
