package algorithm.codingtest.basic.bruteforce.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_14889 {
  static int N;
  static int[][] arr;
  static boolean[] team;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    team = new boolean[N];
    int answer = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < (1 << N); i++) {
      int count = 0;
      for (int j = 0; j < N; j++) {
        if ((i & (1 << j)) != 0) {
          count++;
        }
      }
      if (count == N / 2) {
        for (int j = 0; j < N; j++) {
          team[j] = (i & (1 << j)) != 0;
        }
        int temp = cal();
        answer = Math.min(answer, temp);
      }
    }
    System.out.println(answer);
  }

  public static int cal() {
    int startTeam = 0;
    int linkTeam = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (team[i] == team[j] && team[i]) {
          startTeam += arr[i][j];
        } else if (team[i] == team[j] && !team[i]) {
          linkTeam += arr[i][j];
        }
      }
    }
    return Math.abs(startTeam - linkTeam);
  }
}
