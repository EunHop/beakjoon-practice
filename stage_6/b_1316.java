package stage_6;

import java.util.Scanner;

public class b_1316 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int count = scan.nextInt();
    int result = count;
    for(int i=0; i<count; i++) {
      String word = scan.next();
      // 소문자만 받으니까 26개
      // 기본 false 들어감
      boolean[] arr = new boolean[26];
      arr[word.charAt(0) - 'a'] = true;
      for(int j=1; j<word.length(); j++) {
        char current = word.charAt(j);
        if(current != word.charAt(j-1) && arr[current-'a']) {
          result--;
          break;
        }
        arr[current-'a']=true;
      }
    }
    System.out.println(result);
  }
}
