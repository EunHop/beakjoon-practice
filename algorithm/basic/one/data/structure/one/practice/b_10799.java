package algorithm.basic.one.data.structure.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_10799 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Stack<Character> stack = new Stack<>();
    int stickCount = 0;
    for(int i=0; i<str.length(); i++) {
      if(str.charAt(i)=='(') {
        stack.push(str.charAt(i));
      } else {
        stack.pop();
        if(str.charAt(i-1)=='(') {
          stickCount += stack.size();
        } else {
          stickCount += 1;
        }
      }
    }
    System.out.println(stickCount);
  }
}