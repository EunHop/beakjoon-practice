package algorithm.basic.one.data.structure.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_10809 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    // a ~ z 개수는 26개 이다.
    int[] count = new int[26];
    // 배열을 모두 -1로 채워준다.
    Arrays.fill(count, -1);
    for (int i = 0; i < str.length(); i++) {
      // 처음 등장하는 위치를 담아야하기 때문에 처음 한번만 담아준다.
      if (count[str.charAt(i) - 'a'] == -1) {
        count[str.charAt(i) - 'a'] = i;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i : count) {
      sb.append(i).append(" ");
    }
    System.out.println(sb);
  }
}
