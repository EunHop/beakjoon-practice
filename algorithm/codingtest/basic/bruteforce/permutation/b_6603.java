package algorithm.codingtest.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_6603 {
  static int k;
  static int[] S, ans;
  static boolean[] visit;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    while (true) {
      sb = new StringBuilder();
      st = new StringTokenizer(br.readLine());
      k = Integer.parseInt(st.nextToken());
      if (k == 0) {
        break;
      }
      S = new int[k];
      ans = new int[k];
      visit = new boolean[k];
      for (int i = 0; i < k; i++) {
        S[i] = Integer.parseInt(st.nextToken());
      }
      dfs(0,0);
      System.out.println(sb);
    }
  }

  //백트래킹을 수행한다.
  //1) 종료조건 depth 가 6일 때, 로또 저장한 배열을 출력한다.
  //2) 종료조건이 아닐 때,
  //visit 배열을 사용해서 중복된 수가 들어오지 못하도록 한다.
  //for문에 초기값을 i=start로 해서, 순열이 아닌 조합을 만들도록 한다.
  public static void dfs(int depth, int start) {
    if (depth == 6) {
      for (int i = 0; i < depth; i++) {
        sb.append(ans[i]).append(' ');
      }
      sb.append('\n');
    }
    for(int i=start; i<k; i++) {
      if(!visit[i]) {
        visit[i] = true;
        ans[depth] = S[i];
        dfs(depth+1, i);
        visit[i] = false;
      }
    }
  }
}
