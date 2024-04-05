package codingTest_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1037 {
  public static void main(String[] arg) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int amount = Integer.parseInt(br.readLine());
    int[] measure = new int[amount];
    int max = 0, min = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<amount; i++) {
      measure[i] = Integer.parseInt(st.nextToken());
      if(max < measure[i]) {
        max = measure[i];
      }
      if(i == 0) {
        min = measure[i];
      } else if(min > measure[i]) {
        min = measure[i];
      }
    }
      System.out.println(max*min);
  }
}
