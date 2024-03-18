package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11055 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[N];
    dp[0] = arr[0];
    // 부분적으로 구해놓은 dp로 이전 인덱스를 확인하면서 dp를 교체해간다.
    for (int i = 0; i < N; i++) {
      dp[i] = arr[i];
      for (int j = 0; j < i; j++) {
        if(arr[j]<arr[i]) {
          dp[i] = Math.max(dp[j]+arr[i], dp[i]);
        }
      }
    }
    int result = Integer.MIN_VALUE;
    for(int i : dp) {
      result = Math.max(result, i);
    }
    System.out.println(result);
  }
}
