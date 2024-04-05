package stage_6;

import java.util.Scanner;

public class b_1157 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // 대소문자를 구분하지 않고 중복 갯수를 넣는다.
    String word = scan.next().toUpperCase();
    int[] a = new int[26];
    int max = 0;
    char result = 0;
    // A ~ Z = 65 ~ 90
    // 따라서 배열 길이는 26
    for(int i=0; i<word.length(); i++) {
        a[word.charAt(i)-'A']++;
        if(a[word.charAt(i)-'A'] > max) {
          max = a[word.charAt(i)-'A'];
          result = word.charAt(i);
        } else if(max == a[word.charAt(i)-'A']) {
          result = '?';
        }
    }
    System.out.println(result);
  }
}
