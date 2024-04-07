package algorithm.basic.one.data.math.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_9613 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] num = new int[n];
      for (int j = 0; j < n; j++) {
        num[j] = Integer.parseInt(st.nextToken());
      }
      long result = 0;
      for (int j = 0; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          result += gcd(num[j], num[k]);
        }
      }
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }

  public static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
