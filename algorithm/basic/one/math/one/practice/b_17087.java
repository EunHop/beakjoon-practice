package algorithm.basic.one.math.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_17087 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    // 동생들 위치
    int[] distance = new int[N];
    for(int i=0; i<N; i++) {
      distance[i] = Math.abs(S-Integer.parseInt(st.nextToken()));
    }
    // 맨 처음 동생을 찾은 거리
    int d = distance[0];
    // N=1 일 수도 있기 때문에 0부터 시작한다. 어차피 같은 수끼리 최대공약수는 같은 수이니까.
    for(int i=0; i<N; i++) {
      // 현재 최대공약수로 다음 최대공약수를 찾는다.
      d = gcd(d, distance[i]);
    }
    System.out.println(d);
  }
  public static int gcd(int a, int b) {
    if(b==0) {
      return a;
    }
    return gcd(b, a%b);
  }
}
