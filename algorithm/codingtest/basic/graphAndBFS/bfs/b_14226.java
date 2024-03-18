package algorithm.codingtest.basic.graphAndBFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b_14226 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int S = Integer.parseInt(br.readLine());
    BFS(S);
  }

  public static void BFS(int S) {
    Queue<Emoticon> queue = new LinkedList<>();
    // visited[screen][clipBoard]
    boolean[][] visited = new boolean[1001][1001];
    queue.offer(new Emoticon(1, 0, 0));
    visited[1][0] = true;
    while (!queue.isEmpty()) {
      Emoticon cur = queue.poll();
      if (cur.screen == S) {
        System.out.println(cur.time);
        return;
      }
      // 복사, 현재 스크린을 복사한 적이 없을때
      if (!visited[cur.screen][cur.screen]) {
        queue.offer(new Emoticon(cur.screen, cur.screen, cur.time + 1));
        visited[cur.screen][cur.screen] = true;
      }
      // 붙여넣기, 복사가 되어있고 붙여넣기 했을때 1000을 넘지않고 붙여넣은 적이 없을 때
      if (cur.clipBoard != 0 && cur.screen + cur.clipBoard <= 1000 && !visited[cur.screen + cur.clipBoard][cur.clipBoard]) {
        queue.offer(new Emoticon(cur.screen + cur.clipBoard, cur.clipBoard, cur.time + 1));
        visited[cur.screen + cur.clipBoard][cur.clipBoard] = true;
      }
      // 삭제, 스크린이 0보다 크고 삭제한 적이 없을 때
      if (cur.screen > 0 && !visited[cur.screen - 1][cur.clipBoard]) {
        queue.offer(new Emoticon(cur.screen-1, cur.clipBoard, cur.time+1));
        visited[cur.screen - 1][cur.clipBoard]=true;
      }
    }
  }

  public static class Emoticon {
    int screen;
    int clipBoard;
    int time;

    public Emoticon(int screen, int clipBoard, int time) {
      this.screen = screen;
      this.clipBoard = clipBoard;
      this.time = time;
    }
  }
}
