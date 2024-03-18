package algorithm.codingtest.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_2309 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[9];
    int max = 0;
    for(int i=0; i<arr.length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      max += arr[i];
    }
    for(int j=0; j<arr.length-1; j++) {
      for(int k=j+1; k<arr.length; k++) {
        if(max-arr[j]-arr[k] == 100) {
          arr[j] = arr[k] = 0;

          // 오름차순으로 배열 정렬
          Arrays.sort(arr);
          // 정렬했기떄문에 앞에 2개는 0이라 2부터 보면 됨.
          for(int l=2; l<arr.length; l++) {
            System.out.println(arr[l]);
          }
          // 결과를 반환했으므로 main 함수를 끝냄.
          return;
        }
      }
    }
  }
}
