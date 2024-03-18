package algorithm.codingtest.basic.dp.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11054 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    // 왼쪽부터 시작하는 오름차순 수열
    int[] lDp = new int[N];
    // 오른쪽부터 시작하는 오름차순 수열 (왼쪽부터 내림차순과 같다)
    int[] rDp = new int[N];
    // LIS (오름차순) 부분 수열과 LDS(내림차순) 부분 수열을 합치고 1개씩 원소가 겹치므로 -1을 해주면 된다.
    for(int i=0; i<N; i++) {
      lDp[i] = 1;
      rDp[N-1-i] = 1;
      for(int j=0; j<i; j++) {
        if(arr[i]>arr[j]) {
          lDp[i] = Math.max(lDp[i], lDp[j]+1);
        }
        if(arr[N-1-i] > arr[N-1-j]) {
          rDp[N-1-i] = Math.max(rDp[N-1-i], rDp[N-1-j]+1);
        }
      }
    }
    int[] bDp = new int[N];
    int result = Integer.MIN_VALUE;
    for(int i=0; i<N; i++) {
      bDp[i] = lDp[i]+rDp[i]-1;
    }
    for(int i : bDp) {
      result = Math.max(result, i);
    }
    System.out.println(result);
  }
}
