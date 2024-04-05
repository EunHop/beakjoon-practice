package algorithm.basic.one.data.structure.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_1158 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      queue.offer(i);
    }
    StringBuilder sb = new StringBuilder();
    sb.append("<");
    while (!queue.isEmpty()) {
      // K-1번 빼서 다시 뒤에 넣는다.
      for (int i = 0; i < K - 1; i++) {
        queue.offer(queue.poll());
      }
      // K번째 사람이 제일 앞에 있으니 뺀다.
      sb.append(queue.poll()).append(", ");
    }
    // 마지막에 추가된 ", " 삭제해주는 작업
    sb.setLength(sb.length() - 2);
    sb.append(">");
    System.out.println(sb);
  }
}