package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1476 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int E = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int e = 1;
    int s = 1;
    int m = 1;
    int count = 1;
    while (!(e==E && s==S && m==M)) {
      if(e>=15)
        e=1;
      else
        e++;
      if(s>=28)
        s=1;
      else
        s++;
      if(m>=19)
        m=1;
      else
        m++;
      count++;
    }

    System.out.println(count);
  }
}
