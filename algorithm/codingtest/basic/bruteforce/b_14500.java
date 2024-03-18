package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14500 {
  static int N, M;
  static int[][] board;
  static boolean[][] visited;
  static int answer;
  static int[] dy = {0, 0, -1, 1};
  static int[] dx = {-1, 1, 0, 0};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // N x M board 생성
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    // 입력값 board에 입력
    for(int i=0; i<N; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // visited로 방문표시해서 깊이가 4인 깊이우선탐색(dfs)
    // 방문표시 초기화
    visited = new boolean[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        visited[i][j] = true;
        dfs(1, i, j, board[i][j]);
        visited[i][j] = false;
      }
    }
    System.out.println(answer);
  }
  public static void dfs(int count, int y, int x, int sum) {
    if(count==4) {
      answer = Math.max(answer, sum);
      return;
    }
    // 상하좌우 방문
    for(int i=0; i<4; i++) {
      int curY = y + dy[i];
      int curX = x + dx[i];
      // curY 나 curX가 0보다 작거나 board의 크기를 넘거나 이미 방문한 경우
      if(curY < 0 || curY >= N || curX < 0 || curX >=M || visited[curY][curX])
        continue;
      visited[curY][curX] = true;
      // ㅏ, ㅓ, ㅗ, ㅜ는 기준점으로 돌아와서 방문표시하는 식으로 처리하면 된다.
      // 생각해보면 이해된다.
      if(count==2) {
        dfs(count+1, y, x, sum+board[curY][curX]);
      }
      // 기준점을 옮겨서 깊이 탐색
      dfs(count+1, curY, curX, sum+board[curY][curX]);

      // 방문표시 초기화
      visited[curY][curX] = false;
    }
  }
}
