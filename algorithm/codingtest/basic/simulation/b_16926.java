package algorithm.codingtest.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_16926 {
  static int N, M;
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i=0; i<R; i++) {
      rotateArr();
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
  public static void rotateArr() {
    int[][] temp = new int[N][M];
    int K = Math.min(N,M);
    for(int i=0; i<K/2; i++) {
      // 위쪽 돌리기
      for(int j=i; j<M-i-1; j++) {
        temp[i][j] = arr[i][j+1];
      }
      // 왼쪽 돌리기
      for(int j=i; j<N-i-1; j++) {
        temp[j+1][i] = arr[j][i];
      }
      // 오른쪽 돌리기
      for(int j=i; j<N-i-1; j++) {
        temp[j][M-i-1] = arr[j+1][M-i-1];
      }
      // 아래쪽 돌리기
      for(int j=i; j<M-i-1; j++) {
        temp[N-1-i][j+1] = arr[N-1-i][j];
      }
    }
    arr = temp;
  }
}
