package stage_6;


import java.util.Scanner;

public class b_10988 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String word = scan.next();
      for(int i=0; i<word.length()/2; i++) {
        if(word.charAt(i) == word.charAt(word.length()-1-i)) {
          continue;
        } else {
          System.out.println(0);
          return;
        }
      }
    System.out.println(1);
  }
}
