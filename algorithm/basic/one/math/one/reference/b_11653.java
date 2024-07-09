package algorithm.basic.one.math.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 소인수분해
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 * 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
 * 이번 문제에서는 단일 수에 대한 소인수분해를 요구하므로, 모든 소수를 구하는 방법은 성능이 다소 떨어질 수 있다.
 * 하지만, 많은 수에 대해 반복적으로 소인수분해를 수행할 때는 이 방법이 유용하다.
 */
public class b_11653 {
  static int MAX = 10_000_000;
  static boolean[] isPrime = new boolean[MAX + 1];
  static ArrayList<Integer> primes = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    findPrime();
    for (int prime : primes) {
      // prime * prime > N인 경우, N이 이미 소수임을 의미합니다.
      // ex) prime = 5, N = 7
      if (prime * prime > N) break;
      while (N % prime == 0) {
        sb.append(prime).append("\n");
        N /= prime;
      }
    }
    // 반복문이 끝나도 N > 1 이라면, N은 소수입니다.
    if(N > 1) sb.append(N).append("\n");
    System.out.println(sb.toString());
  }

  static void findPrime() {
    isPrime[0] = true;
    isPrime[1] = true;
    for (int i = 2; i*i <= MAX; i++) {
      if (!isPrime[i]) {
        for (int j = i * i; j <= MAX; j += i) {
          isPrime[j] = true;
        }
      }
    }
    for (int i = 2; i <= MAX; i++) {
      if (!isPrime[i]) primes.add(i);
    }
  }
}
