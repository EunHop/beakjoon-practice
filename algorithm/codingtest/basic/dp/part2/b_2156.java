package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2156 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    // n==3이면 0+1 or 1+2 or 1+3 중에 최대값 고르기
    // if n>3 dp[i]의 경우의 수
    //1. i를 마시지 않았을 때-> i-1번째 까지 마신 것 -> dp [i-1]
    //2. i를 마시고, i-1을 마시지 않았을 때 -> dp[i-2] + i 마신 것 -> dp [i-2] + arr [i]
    //3. i를 마시고, i-1을 마셨을 때 -> i-2을 마시지 않았을 때 + i + i-1 -> dp [i-3] + arr [i] + arr [i-1]
    for (int i = 0; i < n; i++) {
      if(i==0) {
        dp[i] = arr[i];
        continue;
      }
      if(i==1) {
        dp[i] = arr[i-1] + arr[i];
        continue;
      }
      if(i==2) {
        dp[i] = Math.max(dp[i-1], Math.max(arr[i-1] + arr[i], arr[i-2] + arr[i]));
        continue;
      }
      dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]));
    }
    System.out.println(dp[n-1]);
  }
}
