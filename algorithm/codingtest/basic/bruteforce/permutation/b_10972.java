package algorithm.codingtest.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10972 {
  static int N;
  static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    if(nextPermutation()) {
      for(int j=0; j<N; j++) {
        sb.append(arr[j]).append(' ');
      }
    }
    else {
      sb.append(-1);
    }
    System.out.println(sb);
  }
  // 다음 순열 알고리즘
  public static boolean nextPermutation() {
    int point = -1;
    for(int i=N-1; i>0; i--) {
      if(arr[i-1]<arr[i]) {
        point = i;
        break;
      }
    }
    if(point==-1) {
      return false;
    }
    int change = -1;
    for(int j=N-1; j>point-1; j--) {
      if(arr[point-1]<arr[j]) {
        change = j;
        break;
      }
    }
    swap(point-1, change);
    change = N-1;
    while (point<change) {
      swap(point, change);
      point++;
      change--;
    }
    return true;
  }
  public static void swap(int point, int change) {
    int temp = arr[change];
    arr[change] = arr[point];
    arr[point] = temp;
  }
}
