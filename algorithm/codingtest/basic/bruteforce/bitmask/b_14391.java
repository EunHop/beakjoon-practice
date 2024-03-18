package algorithm.codingtest.basic.bruteforce.bitmask;

// https://code-lab1.tistory.com/101

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14391 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] paper = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        paper[i][j] = str.charAt(j) - '0';
      }
    }
    int maxSum = 0;
    // 가로 = 0 세로 != 0
    for(int i=0; i<(1<<N*M); i++) {
      int sum = 0;
      // 가로 찾기
      for(int j=0; j<N; j++) {
        int rowSum = 0;
        for(int k=0; k<M; k++) {
          int colIdx = j*M+k;
          // 해당 칸이 가로일 경우
          if((i&(1<<colIdx)) == 0) {
            rowSum = rowSum*10 + paper[j][k];
          }
          // 해당 칸이 세로일 경우
          else {
            sum += rowSum;
            rowSum = 0;
          }
        }
        sum += rowSum;
      }
      // 세로 찾기
      for(int j=0; j<M; j++) {
        int colSum = 0;
        for(int k=0; k<N; k++) {
          int rowIdx = k*M+j;
          // 해당 칸이 세로일 경우
          if((i&(1<<rowIdx)) != 0) {
            colSum = colSum*10 + paper[k][j];
          }
          // 해당 칸이 가로일 경우
          else {
            sum += colSum;
            colSum = 0;
          }
        }
        sum += colSum;
      }
      maxSum = Math.max(maxSum, sum);
    }
    System.out.println(maxSum);
  }
}
