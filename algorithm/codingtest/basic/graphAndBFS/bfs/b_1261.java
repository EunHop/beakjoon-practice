package algorithm.codingtest.basic.graphAndBFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class b_1261 {
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int M = Integer.parseInt(str[0]);
    int N = Integer.parseInt(str[1]);
    int[][] map = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str2 = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str2.charAt(j) - '0';
      }
    }
    BFS(map, N, M);
  }

  public static void BFS(int[][] map, int N, int M) {
    Queue<Point> queue = new PriorityQueue<>();
    boolean[][] visited = new boolean[N][M];
    queue.offer(new Point(0, 0, 0));
    visited[0][0] = true;
    while (!queue.isEmpty()) {
      Point cur = queue.poll();
      if (cur.x == M - 1 && cur.y == N - 1) {
        System.out.println(cur.count);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx]) {
          if (map[ny][nx] == 0) {
            queue.offer(new Point(nx, ny, cur.count));
            visited[ny][nx] = true;
          }
          if (map[ny][nx] == 1) {
            queue.offer(new Point(nx, ny, cur.count + 1));
            visited[ny][nx] = true;
          }
        }
      }
    }
  }

  public static class Point implements Comparable<Point> {
    int x;
    int y;
    int count;

    public Point(int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }

    @Override
    public int compareTo(Point o) {
      return this.count - o.count;
    }
  }
}
