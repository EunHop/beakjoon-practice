package algorithm.codingtest.basic.bruteforce.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_18290 {
  static int N, M, K, result = Integer.MIN_VALUE;
  static int[][] ans;
  static boolean[][] visited;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    ans = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        ans[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    search(0,0,0,0);
    System.out.println(result);
  }

  public static void search(int x, int y, int count, int sum) {
    if (count == K) {
      result = Math.max(result, sum);
      return;
    }
    for (int i = x; i < N; i++) {
      for (int j = (x==i) ? y : 0; j < M; j++) {
        if (check(i, j)) {
          visited[i][j] = true;
          search(i, j, count + 1, sum + ans[i][j]);
          visited[i][j] = false;
        }
      }
    }
  }

  public static boolean check(int x, int y) {
    if (visited[x][y]) {
      return false;
    } else {
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M ) {
          if(visited[nx][ny])
            return false;
        }
      }
    }
    return true;
  }
}
