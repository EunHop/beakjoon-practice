package algorithm.basic.one.data.structure.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_17298 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] answer = new int[N];
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    // A 배열에 입력 담기
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    Stack<Integer> stack = new Stack<>();
    for(int i=0; i<N; i++) {
      while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
        answer[stack.pop()] = A[i];
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
    StringBuilder sb = new StringBuilder();
    for (int i : answer) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}
