package algorithm.codingtest.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14890 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int count = 0;
    // 가로로 가능한 길 확인
    for (int i = 0; i < N; i++) {
      // 처음엔 2차원 배열로 만들었었다. 그런데 생각해보니 어차피 한줄에서의 조건들이니까
      // 한줄의 조건이 끝나면 초기화해주는 것이 더 효율적이다.
      boolean[] alreadyPut = new boolean[N];
      for (int j = 0; j < N - 1; j++) {
        // 인접한 두 수의 뺄셈이 -1보다 작거나 1보다 크다면 못가는 길이므로 반복문을 종료하고 다음 가로줄로 이동한다.
        // -1보다 작거나 1보다 크다의 조건은 절대값으로 치환하면 줄일 수 있다.
        if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
          break;
        }
        // 다음 칸의 높이가 더 큰 상황
        if (map[i][j] - map[i][j + 1] == -1) {
          // k 반복문 안에서 break 를 하면 j 반복문을 break 할 조건이 없다.
          // j 반복문에 이름을 달아서 break loopJ; 로도 할 수 있지만 일단은 이렇게 하는걸로.
          boolean notSame = false;
          for (int k = 0; k < L; k++) {
            // 0보다 작으면 배열의 크기를 넘기 때문에 경사로를 둘 수가 없다. 불가능 한 길이다.
            if(j-k < 0) {
              notSame = true;
              break;
            }
            // 경사로를 둘 칸의 높이는 같아야하는데 같지 않다면 불가능 한 길이다.
            // 이미 경사로가 놓아져 있다면 여기에 경사로를 못 두니까 불가능 한 길
            // 두 조건 중 하나라도 틀리면 불가능 한 길이다.
            if (map[i][j] != map[i][j - k] || alreadyPut[j-k]) {
              notSame = true;
              break;
            }
            // 위에 조건문을 거쳐서 여기까지 왔다면 경사로를 둘 수 있다는 뜻
            alreadyPut[j-k] = true;
          }
          // 위 조건문중 하나라도 틀려서 notSame = true 가 됐다면 불가능한 길이므로 j 반복문을 빠져나간다.
          if (notSame) {
            break;
          }
        }
        // 다음 칸의 높이가 더 작은 상황
        if (map[i][j] - map[i][j + 1] == 1) {
          // k 반복문 안에서 break 를 하면 j 반복문을 break 할 조건이 없다.
          // j 반복문에 이름을 달아서 break loopJ; 로도 할 수 있지만 일단은 이렇게 하는걸로.
          boolean notSame = false;
          for (int k = 0; k < L; k++) {
            // N보다 크거나 같으면 배열의 크기를 넘었기 떄문에 경사로를 둘 수 없다. 불가능 한 길이다.
            if(j + 1 + k >= N) {
              notSame = true;
              break;
            }
            // 경사로를 둘 칸의 높이는 같아야하는데 같지 않다면 불가능 한 길이다.
            // 이미 경사로가 놓아져 있다면 여기에 경사로를 못 두니까 불가능 한 길
            // 두 조건 중 하나라도 틀리면 불가능 한 길이다.
            if (map[i][j + 1] != map[i][j + 1 + k] || alreadyPut[j+1+k]) {
              notSame = true;
              break;
            }
            // 위에 조건문을 거쳐서 여기까지 왔다면 경사로를 둘 수 있다는 뜻
            alreadyPut[j+1+k]=true;
          }
          // 위 조건문중 하나라도 틀려서 notSame = true 가 됐다면 불가능한 길이므로 j 반복문을 빠져나간다.
          if (notSame) {
            break;
          }
        }
        // 모든 조건을 거쳐서 마지막 칸까지 오게됐다면 가능한 길 이라는 뜻
        if(j==N-2) {
          count++;
        }
      }
    }
    // 세로로 가능한 길 확인
    // 이전 중첩 for 문에서 map[i][j]를 map[j][i]로 바꿔주면 된다.
    // 그 외에는 모두 같다.
    for (int i = 0; i < N; i++) {
      boolean[] alreadyPut = new boolean[N];
      for (int j = 0; j < N - 1; j++) {
        if (Math.abs(map[j][i] - map[j + 1][i]) > 1) {
          break;
        }
        if (map[j][i] - map[j + 1][i] == -1) {
          boolean notSame = false;
          for (int k = 0; k < L; k++) {
            if(j-k < 0) {
              notSame = true;
              break;
            }
            if (map[j][i] != map[j - k][i] || alreadyPut[j-k]) {
              notSame = true;
              break;
            }
            alreadyPut[j-k] = true;
          }
          if (notSame) {
            break;
          }
        }
        if (map[j][i] - map[j + 1][i] == 1) {
          boolean notSame = false;
          for (int k = 0; k < L; k++) {
            if(j + 1 + k >= N) {
              notSame = true;
              break;
            }
            if (map[j + 1][i] != map[j + 1 + k][i] || alreadyPut[j+1+k]) {
              notSame = true;
              break;
            }
            alreadyPut[j+1+k]=true;
          }
          if (notSame) {
            break;
          }
        }
        if(j==N-2) {
          count++;
        }
      }
    }
    // 지나갈 수 있는 길 출력
    System.out.println(count);
  }
}
