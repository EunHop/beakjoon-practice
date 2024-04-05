package codingTest_basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_17425 {
  final static int MAX = 1000001; // 자연수 N의 최대 크기만큼
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    long[] fx = new long[MAX]; // fx : 각 자연수의 모든 약수를 더한 값 저장
    long[] gx = new long[MAX]; // gx : 해당 자연수 이하의 모든 fx값을 더한 값 저장

    Arrays.fill(fx, 1); // 모든 자연수들은 약수 1을 가지므로 약수 1 채움

    for(int i=2; i<MAX; i++) {
      for(int j=1; i*j<MAX; j++) {  // i를 약수로 가지는 i*j들을 구한다 max%i만큼 반복문이 줄어든다.
        fx[i*j] += i;
      }
    }

    for(int k=1; k<MAX; k++) {
      gx[k] += gx[k-1] + fx[k];
    }

    int amount = Integer.parseInt(br.readLine());
    for(int l=0; l<amount; l++) {
      int num = Integer.parseInt(br.readLine());
      sb.append(gx[num]).append('\n');
    }
    System.out.println(sb);
  }
}

