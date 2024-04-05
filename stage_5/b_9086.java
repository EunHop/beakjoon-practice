package stage_5;

import java.util.Scanner;

public class b_9086 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int amount = scan.nextInt();
    String[] word = new String[amount];
    for(int i=0; i<amount; i++) {
      word[i] = scan.next();
    }
    for(int i=0; i<amount; i++) {
      System.out.print(word[i].toCharArray()[0]);
      System.out.println(word[i].toCharArray()[word[i].toCharArray().length-1]);
    }
  }
}
