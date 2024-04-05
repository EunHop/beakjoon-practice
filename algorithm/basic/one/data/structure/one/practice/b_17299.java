package algorithm.basic.one.data.structure.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class b_17299 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 입력을 배열에 담는다.
    for(int i=0; i<N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    int[] F = new int[1_000_001];
    // 등장 횟수를 배열에 담는다.
    // 어떤 숫자가 들어올지 모르기 때문에 최대 크기로 지정해 주어야 한다.
    for(int i=0; i<N; i++) {
      // 숫자를 인덱스로 해서 카운트하면 된다.
      F[A[i]]++;
    }
    int[] answer = new int[N];
    Stack<Integer> stack = new Stack<>();
    for(int i=0; i<N; i++) {
      while (!stack.isEmpty() && F[A[stack.peek()]] < F[A[i]]) {
        answer[stack.pop()] = A[i];
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
    StringBuilder sb = new StringBuilder();
    for(int i : answer) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}
