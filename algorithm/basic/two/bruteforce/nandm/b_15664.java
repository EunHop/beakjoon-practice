package algorithm.basic.two.bruteforce.nandm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * N과 M (10)
 * N개의 자연수 중에서 M개를 고른 수열
 * 고른 수열은 비내림차순이어야 한다.
 * 중복되는 수열은 한번만 출력, 각 수열은 공백으로 구분해서 출력해야 한다.
 */
public class b_15664 {
  static int N, M;
  static int[] nums, result;
  static boolean[] used;
  static HashSet<String> hs;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[N];
    used = new boolean[N];
    result = new int[M];
    // HashSet 사용해서 중복제거
    hs = new HashSet<>();
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }
    // int 형 배열, 즉 primitive 형이므로 Arrays.sort() 를 사용
    // reference 형이면 Collections.sort() 를 사용
    // 오름차순 정렬 후 백트래킹으로 처리
    Arrays.sort(nums);

    backTracking(0, 0);
  }
  static void backTracking(int at, int depth) {
    // 재귀 함수 종료 조건
    if(depth == M) {
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<M; i++) {
        sb.append(result[i]).append(" ");
      }
      String sequence = sb.toString().trim();
      if(!hs.contains(sequence)) {
        hs.add(sequence);
        System.out.println(sequence);
      }
      // 종료
      return;
    }
    // 비내림차순을 위해 at 설정
    for(int i=at; i<N; i++) {
      if (!used[i]) {
        used[i] = true;
        result[depth] = nums[i];
        backTracking(i, depth+1);
        used[i] = false;
      }
    }
  }
}
