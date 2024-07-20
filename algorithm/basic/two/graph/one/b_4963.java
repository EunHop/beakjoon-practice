package algorithm.basic.two.graph.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 섬의 개수
 */
public class b_4963 {
  static int[][] map;
  static boolean[][] visited;
  static int w, h;
  static StringBuilder sb = new StringBuilder();
  // 12시부터 시계방향
  static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
  static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());
      if(w == 0 && h == 0) {
        break;
      }
      map = new int[h][w];
      visited = new boolean[h][w];
      for(int i=0; i<h; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<w; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int islandCount = 0;
      for(int y=0; y<h; y++) {
        for(int x=0; x<w; x++) {
          if(map[y][x] == 1 && !visited[y][x]) {
            visited[y][x] = true;
            dfs(x,y);
            islandCount++;
          }
        }
      }
      sb.append(islandCount).append('\n');
    }
    System.out.println(sb);
  }
  static void dfs(int x, int y) {
    for(int i=0; i<8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx >= 0 && nx < w && ny >= 0 && ny < h && map[ny][nx] == 1 && !visited[ny][nx]) {
        visited[ny][nx] = true;
        dfs(nx, ny);
      }
    }
  }
}