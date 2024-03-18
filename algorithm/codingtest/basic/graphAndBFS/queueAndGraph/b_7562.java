package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_7562 {
  static int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
  static int[] dy = {-2, -2, 2, 2, -1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      int I = Integer.parseInt(br.readLine());
      int[][] map = new int[I][I];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int fromX = Integer.parseInt(st.nextToken());
      int fromY = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int toX = Integer.parseInt(st.nextToken());
      int toY = Integer.parseInt(st.nextToken());
      int dist = BFS(map, I, fromX, fromY, toX, toY);
      System.out.println(dist);
    }
  }

  public static class Point {
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }
  }

  public static int BFS(int[][] map, int I, int fromX, int fromY, int toX, int toY) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(fromX, fromY, 0));
    map[fromX][fromY] = 1;
    while (!queue.isEmpty()) {
      Point cur = queue.poll();
      // 목표 좌표를 확인 하는 코드 위치 더 이상 움직일 필요 없으니 리턴한다.
      if(cur.x==toX && cur.y==toY) {
        return cur.dist;
      }
      for (int i = 0; i < 8; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx >= 0 && nx < I && ny >= 0 && ny < I && map[nx][ny] == 0) {
          queue.offer(new Point(nx,ny, cur.dist+1));
          map[nx][ny]=1;
        }
      }
    }
    return -1;
  }
}
