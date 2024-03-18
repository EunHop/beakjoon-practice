package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_3085 {
  public static char[][] arr;
  public static int N;
  public static int MAX = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new char[N][N];

    for(int i=0; i<N; i++) {
      String line = br.readLine();
      for(int j=0; j<line.length(); j++) {
        arr[i][j] = line.charAt(j);
      }
    }

    // 오른쪽으로 인접한 사탕 바꿔보기
    for(int i=0; i<N; i++) {
      for(int j=0; j<N-1; j++) {
        swap(i, j, i, j+1);
        // 최대 개수 찾기
        search();
        // swap 한 것을 다시 되돌리기
        swap(i, j, i, j+1);
      }
    }

    // 아래쪽으로 인접한 사탕 바꿔보기
    for(int i=0; i<N; i++) {
      for(int j=0; j<N-1; j++) {
        swap(j, i, j+1, i);
        // 최대 개수 찾기
        search();
        // swap 한 것을 다시 되돌리기
        swap(j, i, j+1, i);
      }
    }

    System.out.println(MAX);
  }

  public static void swap(int y1, int x1, int y2, int x2) {
    char temp = arr[y1][x1];
    arr[y1][x1] = arr[y2][x2];
    arr[y2][x2] = temp;
  }

  public static void search() {
    // 가로로 최대 개수 찾기
    for(int i=0; i<N; i++) {
      int count = 1;
      for(int j=0; j<N-1; j++) {
        if(arr[i][j] == arr[i][j+1])
          count++;
        else
          count = 1;
        if(MAX < count)
          MAX = count;
      }
    }
    // 세로로 최대 개수 찾기
    for(int i=0; i<N; i++) {
      int count = 1;
      for(int j=0; j<N-1; j++) {
        if(arr[j][i] == arr[j+1][i])
          count++;
        else
          count = 1;
        if(MAX < count)
          MAX = count;
      }
    }
  }
}
