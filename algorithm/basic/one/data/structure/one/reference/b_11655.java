package algorithm.basic.one.data.structure.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_11655 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
        if (str.charAt(i) - 'a' < 13) {
          sb.append((char)(str.charAt(i) + 13));
        } else {
          sb.append((char)(str.charAt(i) - 13));
        }
      }
      else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
        if (str.charAt(i) - 'A' < 13) {
          sb.append((char)(str.charAt(i) + 13));
        } else {
          sb.append((char)(str.charAt(i) - 13));
        }
      }
      else {
        sb.append(str.charAt(i));
      }
    }
    System.out.println(sb);
  }
}
