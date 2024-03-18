package algorithm.codingtest.basic.bruteforce.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_1759 {
  static int L, C = Integer.MIN_VALUE;
  static char[] arr, code;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    code = new char[L];
    arr = new char[C];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<C; i++) {
      arr[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(arr);
    password(0,0);
  }
  public static void password(int x,int count) {
    if(count==L) {
      if(valid()) {
        System.out.println(code);
      }
      return;
    }
    for(int i=x; i<C; i++) {
      code[count] = arr[i];
      password(i+1, count+1);
    }
  }

  public static boolean valid() {
    int vowelCount = 0;
    int consonantCount = 0;
    for (char c : code) {
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        consonantCount++;
      } else {
        vowelCount++;
      }
    }
    if (consonantCount >= 1 && vowelCount >= 2) {
      return true;
    } else {
      return false;
    }
  }
}
