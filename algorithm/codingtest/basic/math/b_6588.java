package algorithm.codingtest.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_6588 {
  private static boolean[] prime = new boolean[1000001];

  public static void main(String[] args) throws IOException {

    // br 받기전에 실행할 것!!
    findPrime();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      int n = Integer.parseInt(br.readLine());

      if (n == 0)
        break;

      boolean guess = false;

      for(int i=2; i<=n; i++) {
        if(!prime[i] && !prime[n-i]) {
          System.out.println(n+" = "+i+" + "+(n-i));
          guess = true;
          break;
        }
      }
      if(!guess) {
        System.out.println("Goldbach's conjecture is wrong.");
      }
    }
  }

  // 에라토스테네스의 체
  // 소수 == false, 소수 아니면 true, 1 ~ MAX 까지 범위
  public static void findPrime() {
    prime[0] = prime[1] = true;
    for(int i=2; i<= Math.sqrt(prime.length); i++) {
      if(prime[i])
        continue;
      for(int j=i*i; j< prime.length; j+=i) {
        prime[j] = true;
      }
    }
  }
}

