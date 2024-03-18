package stage_5;

import java.util.Scanner;

public class b_27866 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String word = scan.next();
    char[] wordArray = word.toCharArray();
    int a = scan.nextInt();
    System.out.println(wordArray[a-1]);
  }
}
