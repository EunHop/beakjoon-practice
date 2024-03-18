package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_6064 {
  static int M, N, x, y;
  static boolean check;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for(int i=0; i<T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      x = Integer.parseInt(st.nextToken()) - 1;
      y = Integer.parseInt(st.nextToken()) - 1;
      check = false;
     for(int j=x; j<(M*N); j+=M) {
       if(j % N == y) {
         System.out.println(j+1);
         check = true;
         break;
       }
     }
     if(!check) {
       System.out.println(-1);
     }
    }
  }
}
