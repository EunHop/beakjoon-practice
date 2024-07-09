package algorithm.basic.one.math.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Base Conversion
 */
public class b_11576 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Integer> stack = new Stack<>();
    int AtoDecimal = 0;
    // 10진수로 변환
    for(int i=m-1; i>=0; i--) {
      AtoDecimal += Integer.parseInt(st.nextToken()) * (int) Math.pow(A, i);
    }
    // 각 자리 수를 B 진수로 변환 후 스택에 담아서 빼는 식으로 뒤집기
    while(AtoDecimal > 0) {
      stack.push(AtoDecimal%B);
      AtoDecimal /= B;
    }
    // 스택 빼면서 출력에 담기
    while(!stack.empty()) {
      sb.append(stack.pop()).append(" ");
    }
    // 맨 뒤에 " " 하나 없애기 위해 trim() 사용
    System.out.println(sb.toString().trim());
  }
}
