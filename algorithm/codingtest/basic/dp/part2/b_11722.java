package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11722 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[N];
    for(int i=0; i<N; i++) {
      dp[i] = 1;
      // 이전 배열 비교
      for(int j=0; j<i; j++) {
        if(arr[i]<arr[j]) {
          dp[i] = Math.max(dp[i], dp[j]+1);
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
