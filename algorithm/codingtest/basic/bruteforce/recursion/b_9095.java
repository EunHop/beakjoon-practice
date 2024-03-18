package algorithm.codingtest.basic.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9095 {
  static int n, result = Integer.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++) {
      n = Integer.parseInt(br.readLine());
      result = answer(n);
      System.out.println(result);
    }
  }
  public static int answer(int n) {
    if(n==0) {
      return 1;
    }
    if(n<0) {
      return 0;
    }
    int count = 0;
    count += answer(n-1);
    count += answer(n-2);
    count += answer(n-3);

    return count;
  }
}
