package algorithm.codingtest.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_17427 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    long sum = 0; // int보다 더 많은 수를 받을 수 있는 long
    for(int i=1; i<=num; i++) {
      sum += (long) (num / i) *i;
    }
    System.out.println(sum);
  }
}

