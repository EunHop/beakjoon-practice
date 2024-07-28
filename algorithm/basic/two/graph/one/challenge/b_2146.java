package algorithm.basic.two.graph.one.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_2146 {
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static int N, islandId, result = Integer.MAX_VALUE;
  static int[][] map;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    visited = new boolean[N][N];
    islandId = 2;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          classifyIslands(j, i);
          islandId++;
        }
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] > 1) {
          searchShortestBridge(j, i, map[i][j]);
        }
      }
    }
    System.out.println(result);
  }

  static void classifyIslands(int x, int y) {
    visited[y][x] = true;
    map[y][x] = islandId;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx] && map[ny][nx] != 0) {
        classifyIslands(nx, ny);
      }
    }
  }

  static void searchShortestBridge(int x, int y, int startIsland) {
    Queue<Point> queue = new LinkedList<>();
    boolean[][] islandVisited = new boolean[N][N];
    islandVisited[y][x] = true;
    queue.add(new Point(x, y, 0));
    while (!queue.isEmpty()) {
      Point cur = queue.poll();
      if(map[cur.y][cur.x] > 1 && map[cur.y][cur.x] != startIsland) result = Math.min(result, cur.dist-1);
      if(cur.dist > result) continue;
      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !islandVisited[ny][nx] && map[ny][nx]!=startIsland) {
          islandVisited[ny][nx] = true;
          queue.add(new Point(nx, ny, cur.dist+1));
        }
      }
    }
  }

  static class Point {
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }
}
