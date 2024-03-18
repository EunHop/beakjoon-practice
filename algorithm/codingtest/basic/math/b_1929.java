package algorithm.codingtest.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1929 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());

    boolean[] prime = findPrime(n);

    StringBuilder sb = new StringBuilder();
    for(int i=m; i<=n; i++) {
      //false = 소수
      if(!prime[i])
        sb.append(i).append('\n');
    }
    System.out.print(sb);
  }

  // 에라토스테네스의 체
  // 소수 == false, 소수 아니면 true, 1 ~ MAX 까지 범위
  static boolean[] findPrime(int n) {
    boolean[] prime = new boolean[n+1];

    prime[0] = prime[1] = true;

    for(int i=2; i<=Math.sqrt(n); i++) {
      if(prime[i]) {
        continue;
      }
      for(int j=i*i; j<n+1; j+=i) {
        prime[j] = true;
      }
    }

    return prime;
  }
}
