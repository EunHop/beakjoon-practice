package algorithm.basic.one.data.structure.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_9012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      String str = br.readLine();
      sb.append(check(str) ? "YES" : "NO").append("\n");
    }
    System.out.println(sb);
  }
  public static boolean check(String str) {
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == '(') {
        // ( 를 스택에 넣는다.
        stack.push(c);
      } else {
        // 스택이 비었으면 ) 에 해당하는 ( 가 없으므로 VPS 가 아니다.
        if(stack.isEmpty()) {
          return false;
        }
        // ) 를 만났으므로 해당 ( 를 뺀다.
        stack.pop();
      }
    }
    // for 문을 다 돌고 스택이 비어있어야 VPS 이다.
    return stack.isEmpty();
  }
}
