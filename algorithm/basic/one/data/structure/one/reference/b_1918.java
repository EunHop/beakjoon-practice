package algorithm.basic.one.data.structure.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_1918 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      // 문자면 출력문에 넣고 이번 반복은 이걸로 끝났으니 다음 반복으로
      if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
        sb.append(str.charAt(i));
        continue;
      }
      // '(' 면 스택에 넣고 다음 반복으로
      if (str.charAt(i) == '(') {
        stack.push(str.charAt(i));
        continue;
      }
      // ')' 면 스택의 top 이 '(' 이 될때까지 스택에서 빼서 출력문에 넣고
      // '(' 은 그냥 스택에서 빼서 버림
      if (str.charAt(i) == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.pop();
        continue;
      }
      // 괄호가 아니면 스택의 top 에 있는 연산자 우선순위가
      // 현재 문자의 우선순위보다 크거나 같을경우 스택에서 빼냄
      // ex) 현재 문자가 + or - 면 스택에 있는 + - * / 를 빼야하고
      //     현재 문자가 * or / 면 스택에 있는 * / 를 빼야함
      // 다 뺐으면 현재 문자 스택에 넣어야함
      while (!stack.isEmpty() && priority(stack.peek()) >= priority(str.charAt(i))) {
        sb.append(stack.pop());
      }
      stack.push(str.charAt(i));
    }
    // 남아있는 스택들은 차례대로 빼서 출력문에 넣어주면 됨
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    System.out.println(sb);
  }

  public static int priority(char character) {
    if (character == '+' || character == '-') {
      return 0;
    }
    if (character == '*' || character == '/') {
      return 1;
    }
    return -1;
  }
}
