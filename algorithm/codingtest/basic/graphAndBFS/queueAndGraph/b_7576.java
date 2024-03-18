package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b_7576 {
  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[][] box = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int days = BFS(box,N,M);
    if(AllTomatoCheck(box)) {
      System.out.println(days);
    } else {
      System.out.println(-1);
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
  public static int BFS(int[][] box, int N, int M) {
    boolean[][] visited = new boolean[N][M];
    Queue<Point> queue = new LinkedList<>();
    int days = 0;
    // 익은 토마토를 큐에 넣는 작업
    // 큐에 넣었으니 방문표시 해줘야한다.
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (box[i][j] == 1) {
          queue.offer(new Point(i, j));
          visited[i][j] = true;
        }
      }
    }
    while (!queue.isEmpty()) {
      // 현재 익은 토마토의 개수
      int size = queue.size();
      // 현재 날짜에 익은 토마토를 모두 처리
      for (int j = 0; j < size; j++) {
        Point cur = queue.poll();
        for (int i = 0; i < 4; i++) {
          int nx = cur.x + dx[i];
          int ny = cur.y + dy[i];
          if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && box[nx][ny] == 0) {
            queue.offer(new Point(nx, ny));
            visited[nx][ny] = true;
            box[nx][ny] = 1;
          }
        }
      }
      // 작업을 한 후에 일 수 카운트
      if (!queue.isEmpty()) {
        days++;
      }
    }
    return days;
  }
  public static boolean AllTomatoCheck(int[][] box) {
    for(int[] row : box) {
      for(int tomato : row) {
        if(tomato==0) {
          return false;
        }
      }
    }
    return true;
  }
}
