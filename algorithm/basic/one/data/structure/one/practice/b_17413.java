package algorithm.basic.one.data.structure.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_17413 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();
    // 문자열의 길이만큼 반복
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i)=='<') {
        // '<' 이전까지 담고 있었던 문자 빼기
        while (!stack.isEmpty()) {
          sb.append(stack.pop());
        }
        // '<' 담기
        sb.append(str.charAt(i));
        stack.push(str.charAt(i));
        // 현재 문자에 대해서 끝났기 때문에 밑 부분은 볼 필요가 없어 다음 반복으로 넘김
        continue;
      }
      if(str.charAt(i)=='>') {
        // '>' 를 만나면 '<' 를 담고 있던걸 빼낸다.
        sb.append(str.charAt(i));
        stack.pop();
        // 현재 문자에 대해서 끝났기 때문에 밑 부분은 볼 필요가 없어 다음 반복으로 넘김
        continue;
      }
      // stack 에 다른 문자가 들어가 있지 않은지 확인 후 처리
      if(!stack.isEmpty() && stack.peek()=='<') {
        sb.append(str.charAt(i));
        // 현재 문자에 대해서 끝났기 때문에 밑 부분은 볼 필요가 없어 다음 반복으로 넘김
        continue;
      }
      // 스페이스 문자를 만나면 담고 있던 문자를 빼야함.
      if(str.charAt(i)==' ') {
        while (!stack.isEmpty()) {
          sb.append(stack.pop());
        }
        // 당연히 스페이스 문자도 처리해야 함
        sb.append(str.charAt(i));
        // 현재 문자에 대해서 끝났기 때문에 밑 부분은 볼 필요가 없어 다음 반복으로 넘김
        continue;
      }
      // 역순해야할 문자 담기
      stack.push(str.charAt(i));
    }
    // 마지막에 문자로 끝날 경우 스택에 해당 문자열을 담고 있으므로 처리해주어야함.
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    System.out.println(sb);
  }
}
