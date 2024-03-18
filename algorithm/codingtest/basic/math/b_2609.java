package algorithm.codingtest.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2609 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    System.out.println(gcd(a,b));
    System.out.println(lcm(a,b));
  }

  // 최대공약수 재귀 방식,  최대공약수 = 유클리드 호제법  gcd(a,b) = gcd(b,r)   r = a % b
  static int gcd(int a, int b) {
    if(b==0) return a;
    // gcd(a,b) = gcd(b,r) r = a % b
    return gcd(b, a%b);
  }

  // 최소 공배수 : a * b 했을때 최대공약수가 2번 곱해지는 것이므로 a * b / gcd(a,b) 하면 된다.
  static int lcm(int a, int b) {
    return a * b / gcd(a,b);
  }
}
