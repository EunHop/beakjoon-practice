package algorithm.codingtest.basic.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b_2529 {
  static int k;
  static char[] kArr;
  static boolean[] visit = new boolean[10];
  static ArrayList tempArr = new ArrayList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    k = Integer.parseInt(br.readLine());
    kArr = new char[k];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<k; i++) {
      kArr[i] = st.nextToken().charAt(0);
    }
    dfs(0,"");
    Collections.sort(tempArr);
    System.out.println(tempArr.get(tempArr.size()-1));
    System.out.println(tempArr.get(0));
  }
  public static void dfs(int depth, String cur) {
    if(depth == k+1) {
      tempArr.add(cur);
      return;
    }
    for(int i=0; i<10; i++) {
      if(!visit[i]) {
        if(depth==0 || kArr[depth-1] == '<' && cur.charAt(depth-1)-'0' < i  ||
            kArr[depth-1] == '>' && cur.charAt(depth-1)-'0' > i) {
          visit[i] = true;
          dfs(depth+1, cur+i);
          visit[i] = false;
        }
      }
    }
  }
}
