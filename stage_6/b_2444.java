package stage_6;

import java.util.Scanner;

public class b_2444 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int amount = scan.nextInt();
    for(int i=1; i<=(2*amount-2)/2; i++) {
      for(int j=0; j<(2*amount-2)/2-(i-1); j++) {
        System.out.print(" ");
      }
      for(int k=0; k<2*i-1; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for(int l=0; l<2*amount-1; l++) {
      System.out.print("*");
    }
    System.out.println();
    for(int i=(2*amount-2)/2; i>=1; i--) {
      for(int j=(2*amount-2)/2-(i-1); j>0; j--) {
        System.out.print(" ");
      }
      for(int k=2*i-1; k>0; k--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
