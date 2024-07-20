package algorithm.basic.two.graph.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Two Dots
 */
public class b_16929 {
  static int N, M;
  static char[][] board;
  static boolean[][] visited;
  // 12시부터 시계방향
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  // 사이클이 존재하면 다른 재귀함수도 빠르게 종료시키기 위해서 전역변수 설정
  static boolean foundCycle = false;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new char[N][M];
    for(int i=0; i<N; i++) {
      String str = br.readLine();
      for(int j=0; j<M; j++) {
        board[i][j] = str.charAt(j);
      }
    }
    visited = new boolean[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        if(!visited[i][j]) {
          dfs(j, i, -1, -1, board[i][j]);
          if(foundCycle) {
            System.out.println("Yes");
            return;
          }
        }
      }
    }
    System.out.println("No");
  }
  static void dfs(int x, int y, int px, int py, char color) {
    if(foundCycle) return;
    visited[y][x] = true;
    for(int i=0; i<4; i++) {
      int nx = x+dx[i];
      int ny = y+dy[i];
      // 범위 내에 존재하고 색상이 동일한지, 둘 다 만족하지 못하면 다음 좌표 확인
      if(nx < 0 || nx >= M || ny < 0 || ny >= N || board[ny][nx] != color) continue;
      // 다음 좌표가 이전 좌표가 아닌지, 맞으면 다음 좌표 확인
      if(nx == px && ny == py) continue;
      // 다음 좌표가 이전 좌표가 아니고 이미 방문한 좌표면 사이클이다.
      if(visited[ny][nx]) {
        foundCycle = true;
        return;
      }
      // 다음 좌표가 이전 좌표가 아니고 방문하지 않았다면 다음 좌표로 이동해서 판별한다.
      dfs(nx, ny, x, y, color);
      // 재귀 함수를 거치고 나와서 foundCycle 값이 true 가 되었다면 그 아래에서 바로 확인해야 함수를 바로 끝낼 수 있다.
      if(foundCycle) return;
    }
  }
}
