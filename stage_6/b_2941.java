package stage_6;

import java.util.Scanner;

public class b_2941 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String word = scanner.next();
    String[] alp = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
    for(int i=0; i<alp.length; i++) {
      if(word.contains(alp[i])) {
        word = word.replace(alp[i], "!");
      }
    }
    System.out.println(word.length());
  }
}
