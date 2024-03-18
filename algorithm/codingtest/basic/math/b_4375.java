package algorithm.codingtest.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_4375 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input;
    while ((input = br.readLine())!=null) {
      int n = Integer.parseInt(input);
      int base = 1;
      int count = 1;
      while((base=base%n)!=0) {
        count++;
        base = base*10+1;
      }
      System.out.println(count);
    }
  }
}
