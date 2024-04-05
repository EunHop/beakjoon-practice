package algorithm.basic.one.data.structure.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_10808 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    // a ~ z 개수는 26개 이다.
    int[] count = new int[26];
    for(int i=0; i<str.length(); i++) {
      count[str.charAt(i)-'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for(int i : count) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}
