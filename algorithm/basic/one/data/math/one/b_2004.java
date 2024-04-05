package algorithm.basic.one.data.math.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2004 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int countTwo = countNum(n, 2) - countNum(n - m, 2) - countNum(m, 2);
    int countFive = countNum(n, 5) - countNum(n - m, 5) - countNum(m, 5);
    System.out.println(Math.min(countTwo, countFive));
  }

  public static int countNum(int num, int divisor) {
    int count = 0;
    while (num >= divisor) {
      count += num / divisor;
      num /= divisor;
    }
    return count;
  }
}
