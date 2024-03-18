package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b_2667 {
  static int N;
  static int[][] map;
  static boolean[][] visited;
  static int count;
  static ArrayList<Integer> result;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    visited = new boolean[N][N];
    result = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j) - '0';
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          count = 1;
          dfs(i, j);
          result.add(count);
        }
      }
    }
    Collections.sort(result);
    System.out.println(result.size());
    for (int i : result) System.out.println(i);
  }

  public static void dfs(int x, int y) {
    visited[x][y] = true;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
        count++;
        dfs(nx, ny);
      }
    }
  }
}
