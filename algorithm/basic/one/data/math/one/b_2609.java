package algorithm.basic.one.data.math.one;

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
    StringBuilder sb = new StringBuilder();
    sb.append(gcd(a,b)).append("\n").append(lcm(a,b));
    System.out.println(sb);
  }

  public static int gcd(int a, int b) {
    if(b==0) {
      return a;
    }
    // GCD(581, 322) = GCD(322, 259) = GCD(259, 63) =  GCD(63, 7) = GCD(7, 0) = 7
    return gcd(b, a % b);
  }
  public static int lcm(int a, int b) {
    return a*b/gcd(a,b);
  }
}
