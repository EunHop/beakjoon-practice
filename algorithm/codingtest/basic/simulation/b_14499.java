package algorithm.codingtest.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14499 {
  static int N, M, x, y;
  static int[][] map;

  // 출력은 StringBuilder 에 모았다가 한번에 출력한다.
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    // 맞왜틀을 반복하다 찾은 반례
    // 2 2 1 0 1
    // 0 0
    // 0 1
    // 1
    // 결과
    // 0
    // 입력할 때 y x 순서이다. 거꾸로 넣으니까 틀리지!
    y = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    // 지도 생성
    map = new int[N][M];
    // 지도에 숫자 넣기
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 주사위 생성, 생성자로 인해 모두 0으로 초기화
    Dice dice = new Dice();
    st = new StringTokenizer(br.readLine());
    // K번 명령 실행
    for (int i = 0; i < K; i++) {
      int kNum = Integer.parseInt(st.nextToken());
      switch (kNum) {
        case 1:
          turnEast(dice);
          break;
        case 2:
          turnWest(dice);
          break;
        case 3:
          turnNorth(dice);
          break;
        case 4:
          turnSouth(dice);
          break;
      }
    }
    System.out.println(sb);
  }

  public static class Dice {
    int top;
    int bottom;
    int left;
    int right;
    int front;
    int back;

    public Dice() {
      // 주사위 생성시 모두 0값임.
      this.top = 0;
      this.bottom = 0;
      this.left = 0;
      this.right = 0;
      this.front = 0;
      this.back = 0;
    }
  }

  public static void turnEast(Dice dice) {
    int nx = x + 1;
    int ny = y;
    // 지도를 벗어나지 않는지 확인한다. 벗어나면 출력하지 않는다.
    if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
      // 주사위를 동쪽으로 한번 굴린다.
      int temp = dice.left;
      dice.left = dice.bottom;
      dice.bottom = dice.right;
      dice.right = dice.top;
      dice.top = temp;
      // 주사위 바닥칸과 지도칸의 숫자 비교를 한다.
      bottomChange(dice, nx, ny);
    }
  }

  public static void turnWest(Dice dice) {
    int nx = x - 1;
    int ny = y;
    // 지도를 벗어나지 않는지 확인한다. 벗어나면 출력하지 않는다.
    if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
      // 주사위를 서쪽으로 한번 굴린다.
      int temp = dice.bottom;
      dice.bottom = dice.left;
      dice.left = dice.top;
      dice.top = dice.right;
      dice.right = temp;
      // 주사위 바닥칸과 지도칸의 숫자 비교를 한다.
      bottomChange(dice, nx, ny);
    }
  }

  public static void turnNorth(Dice dice) {
    int nx = x;
    int ny = y - 1;
    // 지도를 벗어나지 않는지 확인한다. 벗어나면 출력하지 않는다.
    if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
      // 주사위를 북쪽으로 한번 굴린다.
      int temp = dice.front;
      dice.front = dice.bottom;
      dice.bottom = dice.back;
      dice.back = dice.top;
      dice.top = temp;
      // 주사위 바닥칸과 지도칸의 숫자 비교를 한다.
      bottomChange(dice, nx, ny);
    }
  }

  public static void turnSouth(Dice dice) {
    int nx = x;
    int ny = y + 1;
    // 지도를 벗어나지 않는지 확인한다. 벗어나면 출력하지 않는다.
    if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
      // 주사위를 남쪽으로 한번 굴린다.
      int temp = dice.bottom;
      dice.bottom = dice.front;
      dice.front = dice.top;
      dice.top = dice.back;
      dice.back = temp;
      // 주사위 바닥칸과 지도칸의 숫자 비교를 한다.
      bottomChange(dice, nx, ny);
    }
  }
  public static void bottomChange(Dice dice, int nx, int ny) {
    if (map[ny][nx] == 0) {
      map[ny][nx] = dice.bottom;
    } else {
      dice.bottom = map[ny][nx];
      map[ny][nx] = 0;
    }
    // 움직였으니 현재위치를 바꿔준다.
    x = nx;
    y = ny;
    sb.append(dice.top).append("\n");
  }
}
