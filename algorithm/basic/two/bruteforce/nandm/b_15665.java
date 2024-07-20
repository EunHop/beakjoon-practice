package algorithm.basic.two.bruteforce.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N과 M (11)
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 된다.
 * 중복되는 수열은 한번만 출력, 각 수열은 공백으로 구분해서 출력해야 한다.
 */
public class b_15665 {
  static int N, M;
  static int[] nums, result;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[N];
    result = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    // int 형 배열, 즉 primitive 형이므로 Arrays.sort() 를 사용
    // reference 형이면 Collections.sort() 를 사용
    // 오름차순 정렬 후 재귀함수로 처리
    Arrays.sort(nums);
    // 중복 제거된 배열 생성, 배열에 요소가 적을수록 재귀함수의 개수도 현저히 줄어든다.
    int[] distinctNums = Arrays.stream(nums).distinct().toArray();
    permutation(distinctNums, 0);
    System.out.println(sb.toString());
  }

  static void permutation(int[] distinctNums, int depth) {
    // 재귀 함수 종료 조건
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(result[i]).append(" ");
      }
      sb.append("\n");
      // 종료
      return;
    }
    for (int distinctNum : distinctNums) {
      result[depth] = distinctNum;
      permutation(distinctNums, depth + 1);
    }
  }
}
