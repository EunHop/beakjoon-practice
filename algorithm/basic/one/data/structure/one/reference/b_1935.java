package algorithm.basic.one.data.structure.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b_1935 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String str = br.readLine();
    double[] arr = new double[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Double.parseDouble(br.readLine());
    }
    Stack<Double> stack = new Stack<>();
    double A, B;
    for (int i = 0; i < str.length(); i++) {
      // A ~ Z = 65 ~ 90
      if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
        stack.push(arr[str.charAt(i)-'A']);
      } else {
        switch (str.charAt(i)) {
          case '/':
            // stack 에는 AB <- 로 담겨있으므로 빼서 연산할 때는 A / B가 되기 위해서
            // 변수에 담아 자리를 바꿔줘야 한다.
            B = stack.pop();
            A = stack.pop();
            stack.push(A / B);
            break;
          case '*':
            B = stack.pop();
            A = stack.pop();
            stack.push(A * B);
            break;
          case '+':
            B = stack.pop();
            A = stack.pop();
            stack.push(A + B);
            break;
          case '-':
            B = stack.pop();
            A = stack.pop();
            stack.push(A - B);
            break;
        }
      }
    }
    // 소수점 둘째 자리까지 출력해야하기 때문에 서식문자로 맞춰줬다.
    // 자바에 서식문자에는 double 을 뜻하는 "%lf"가 없고 "%f"로 통일
    System.out.printf("%.2f", stack.pop());
  }
}
