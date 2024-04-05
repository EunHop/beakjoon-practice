package algorithm.basic.one.data.structure.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_1406 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Stack<Character> leftStack = new Stack<>();
    Stack<Character> rightStack = new Stack<>();
    String str = br.readLine();
    for(int i=0; i<str.length(); i++) {
      leftStack.push(str.charAt(i));
    }
    int M = Integer.parseInt(br.readLine());
    for(int i=0; i<M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();
      switch (command) {
        case "L" :
          if(!leftStack.isEmpty())
            rightStack.push(leftStack.pop());
          break;
        case "D" :
          if(!rightStack.isEmpty())
            leftStack.push(rightStack.pop());
          break;
        case "B" :
          if(!leftStack.isEmpty())
            leftStack.pop();
          break;
        case "P" :
          String char1 = st.nextToken();
          leftStack.push(char1.charAt(0));
          break;
      }
    }
    while (!leftStack.isEmpty()) {
      rightStack.push(leftStack.pop());
    }
    while (!rightStack.isEmpty()) {
      sb.append(rightStack.pop());
    }
    System.out.println(sb);
  }
}
