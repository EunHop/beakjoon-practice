package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1748 {
  static int N, copyN, count, line;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    copyN = N;
    count = 0;
    line = 0;
    while(copyN > 0) {
      copyN /= 10;
      count++;
    }
    for(int i=0; i<count-1; i++) {
      line += (int) (9*Math.pow(10, i)*(i+1));
    }
      line+= (int) ((N-Math.pow(10,count-1)+1)*count);
    System.out.println(line);
  }
}
