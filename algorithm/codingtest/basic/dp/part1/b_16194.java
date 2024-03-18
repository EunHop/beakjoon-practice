package algorithm.codingtest.basic.dp.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_16194 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] P = new int[N+1];
    int[] D = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    //D[0]는 최대값으로 초기화하면 안된다. 초기화하면 최대값을 넘어버려 마이너스의 최대숫자가 되어버리기 때문
    for(int i=1; i<=N; i++) {
    P[i] = Integer.parseInt(st.nextToken());
    D[i] = Integer.MAX_VALUE;
    }
    for(int i=1; i<=N; i++) {
      for(int j=1; j<=i; j++) {
          D[i] = Math.min(D[i], D[i-j]+P[j]);
      }
    }
    System.out.println(D[N]);
  }
}
