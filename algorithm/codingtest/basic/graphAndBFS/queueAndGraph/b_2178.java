package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

//최단거리 문제는 bfs 로 푸는 것이 좋다.
//왜냐면 dfs 는 분기점이 생길 때 마다 끝까지 파고들었다가 다시 돌아와야되는 번거로움이 있어
//한번 지난 노드를 다시 방문하지 않는 bfs에 비해 왔다갔다 하는 점에서 효율성이 떨어지기 때문이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_2178 {
  static int N, M;
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static boolean[][] visited;
  static int[][] map;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    N = Integer.parseInt(str[0]);
    M = Integer.parseInt(str[1]);
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      String str2 = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str2.charAt(j) - '0';
      }
    }
    visited = new boolean[N][M];
    // 0,0 부터 시작하므로 방문표시 하고 시작한다.
    visited[0][0] = true;
    bfs(0, 0);
    System.out.println(map[N - 1][M - 1]);
  }

  public static void bfs(int x, int y) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x, y));
    while (!queue.isEmpty()) {
      Point cur = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
          // 조건에 만족하면 큐에 넣고 방문표시한다.
          queue.offer(new Point(nx, ny));
          visited[nx][ny] = true;
          // 다음 좌표에 현재 좌표 + 1 하면서 카운팅한다.
          map[nx][ny] = map[cur.x][cur.y] + 1;
        }
      }
    }
  }

  public static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
