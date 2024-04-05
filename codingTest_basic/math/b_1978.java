package codingTest_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1978 {
  final static int MAX = 1000;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int amount = Integer.parseInt(br.readLine());
    boolean[] prime = findPrime(MAX);
    int prime_num = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<amount; i++) {
      if(!prime[Integer.parseInt(st.nextToken())]) {
        prime_num++;
      }
    }
    System.out.println(prime_num);
  }

  // 에라토스테네스의 체
  // 소수 == false, 소수 아니면 true, 1 ~ MAX 까지 범위
  static boolean[] findPrime(int max) {
    boolean[] prime = new boolean[max+1]; // 0부터 시작하므로 +1해서 마지막까지 담도록

    // 0, 1은 소수가 아니므로 true 처리
    prime[0] = true;
    prime[1] = true;

    for(int i=2; i<=Math.sqrt(max); i++) {
      // 이미 걸러진 배열은 다음 반복으로 넘어감
      if(prime[i]) {
        continue;
      }
      for(int j=i*i; j<max+1; j+=i) {
        prime[j] = true;
      }
    }
    return prime;
  }
}
