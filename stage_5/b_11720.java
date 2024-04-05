package stage_5;

import java.util.Scanner;

public class b_11720 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int amount = scan.nextInt();
    String number = scan.next();
    int sum = 0;
    for(int i=0; i<amount; i++) {
      sum+=Integer.parseInt(String.valueOf(number.toCharArray()[i]));
    }
    System.out.println(sum);
  }
}
