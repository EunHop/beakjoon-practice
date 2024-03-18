package algorithm.codingtest.basic.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int M = Integer.parseInt(br.readLine());
    int A = 0;
    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      String cal = st.nextToken();
      switch (cal) {
        case "all":
          A = (1 << 21) - 1;
          break;
        case "empty":
          A = 0;
          break;
        default:
          int num = Integer.parseInt(st.nextToken());
          switch (cal) {
            case "add":
              A |= (1 << num);
              break;
            case "remove":
              A &= ~(1 << num);
              break;
            case "check":
              sb.append((A & (1 << num)) != 0 ? 1 : 0).append('\n');
              break;
            case "toggle":
              A ^=(1<<num);
              break;
          }
      }
    }
    System.out.println(sb);
  }
}
