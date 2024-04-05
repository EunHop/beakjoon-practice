package stage_5;

import java.util.Scanner;

public class b_10809 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String word = scan.next();
    int[] alp = new int[26];
    for (int i = 0; i < 26; i++) {
      alp[i] = -1;
      for (int j = 0; j < word.length(); j++) {
        if ((int)word.toCharArray()[j] == (i+97)) {
          if(alp[i]!=-1) {
            continue;
          }
          alp[i] = j;
        }
      }
    }
    for(int k=0; k<alp.length; k++) {
      System.out.print(alp[k]+" ");
    }
  }
}
