package stage_5;

import java.util.Scanner;

public class b_2908 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    StringBuilder sb1 = new StringBuilder(scan.next());
    String reverse1 = sb1.reverse().toString();
    StringBuilder sb2 = new StringBuilder(scan.next());
    String reverse2 = sb2.reverse().toString();

    if(Integer.parseInt(reverse1) > Integer.parseInt(reverse2)) {
      System.out.println(reverse1);
    } else {
      System.out.println(reverse2);
    }
  }
}
