package algorithm.basic.two.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 종이 조각
 */
public class b_14391 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] paper = new int[N][M];
    // paper 입력 받기
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        paper[i][j] = line.charAt(j) - '0';
      }
    }
    int result = 0;
    // 비트 마스크를 사용하여 모든 경우의 수 계산
    for (int bit = 0; bit < (1 << (N * M)); bit++) {
      // 각 경우마다 합계를 나타내는 변수
      int sum = 0;
      // 가로 계산
      for (int i = 0; i < N; i++) {
        int rowSum = 0;
        for (int j = 0; j < M; j++) {
          // 해당 위치에 비트가 1이면 가로 조각
          if ((bit & (1 << i * M + j)) != 0) {
            // 높은 자리부터 더해지므로 * 10 을 해줘야 낮은자리 덧셈 할 수 있다.
            rowSum = rowSum * 10 + paper[i][j];
          } else {
            // 해당 위치가 세로 조각이면 여태까지의 가로 조각을 더해주고 rowSum 을 초기화
            sum += rowSum;
            rowSum = 0;
          }
        }
        // 마지막 가로 조각 합산
        sum += rowSum;
      }
      // 세로 계산
      for (int j = 0; j < M; j++) {
        int colSum = 0;
        for (int i = 0; i < N; i++) {
          // 해당 위치에 비트가 0이면 세로 조각
          if ((bit & (1 << i * M + j)) == 0) {
            // 높은 자리부터 더해지므로 * 10 을 해줘야 낮은자리 덧셈 할 수 있다.
            colSum = colSum * 10 + paper[i][j];
          } else {
            // 해당 위치가 가로 조각이면 여태까지의 세로 조각을 더해주고 colSum 을 초기화
            sum += colSum;
            colSum = 0;
          }
        }
        // 마지막 세로 조각 합산
        sum += colSum;
      }
      // 최대값 갱신
      result = Math.max(result, sum);
    }
    System.out.println(result);
  }
}
