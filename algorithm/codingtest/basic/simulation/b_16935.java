package algorithm.codingtest.basic.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_16935 {
  static int N,M;
  static int[][] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());
    arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < R; i++) {
      int num = Integer.parseInt(st.nextToken());
      switch (num) {
        case 1:
          one();
          break;
        case 2:
          two();
          break;
        case 3:
          three();
          break;
        case 4:
          four();
          break;
        case 5:
          five();
          break;
        case 6:
          six();
          break;
      }
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        sb.append(arr[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
  public static void one() {
    int[][] temp = new int[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        temp[i][j] = arr[N-1-i][j];
      }
    }
    arr = temp;
  }
  public static void two() {
    int[][] temp = new int[N][M];
    for(int i=0; i<N; i++) {
      for(int j=0; j<M; j++) {
        temp[i][j] = arr[i][M-1-j];
      }
    }
    arr = temp;
  }
  public static void three() {
    int[][] temp = new int[M][N];
    for(int i=0; i<M; i++) {
      for(int j=0; j<N; j++) {
        temp[i][j] = arr[N-1-j][i];
      }
    }
    int tempNum = N;
    N = M;
    M = tempNum;
    arr = temp;
  }
  public static void four() {
    int[][] temp = new int[M][N];
    for(int i=0; i<M; i++) {
      for(int j=0; j<N; j++) {
        temp[i][j] = arr[j][M-1-i];
      }
    }
    int tempNum = N;
    N = M;
    M = tempNum;
    arr = temp;
  }
  public static void five() {
    int[][] temp = new int[N][M];
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[i][j] = arr[N/2+i][j];
      }
    }
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[i][M/2+j] = arr[i][j];
      }
    }
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[N/2+i][M/2+j] = arr[i][M/2+j];
      }
    }
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[N/2+i][j] = arr[N/2+i][M/2+j];
      }
    }
    arr = temp;
  }
  public static void six() {
    int[][] temp = new int[N][M];
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[N/2+i][j] = arr[i][j];
      }
    }
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[i][j] = arr[i][M/2+j];
      }
    }
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[i][M/2+j] = arr[N/2+i][M/2+j];
      }
    }
    for(int i=0; i<N/2; i++) {
      for(int j=0; j<M/2; j++) {
        temp[N/2+i][M/2+j] = arr[N/2+i][j];
      }
    }
    arr = temp;
  }
}

