package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_13398 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[][] dp = new int[n][2];
    dp[0][0] = dp[0][1] = arr[0];
    // result = Integer.MIN_VALUE 로 했다가 틀렸다. 아무래도 최대 음수로 뒀다가 Math.max 연산에서 오류가 나는듯
    int result = arr[0];
    for(int i=1; i<n; i++) {
      // dp[i][0] = 특정 수 1개를 제거하지 않은 배열
      // 연속해서 이전배열에 현재 수를 더해주거나, 현재 수를 넣어준다.
      dp[i][0] = Math.max(dp[i-1][0]+arr[i], arr[i]);
      // dp[i][1] = 특정 수 1개를 제거한 배열
      // 특정 수를 제거 하는 경우 = dp[i-1][0] 이전 제거하지 않은 배열을 가져오면 된다.
      // 특정 수를 이미 제거한 경우 = dp[i-1][1]+arr[i] 이미 제거했으므로 현재 수를 더해주기만 하면된다.
      dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1]+arr[i]);
      result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
    }
    System.out.println(result);
  }
}
