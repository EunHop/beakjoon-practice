package stage_3;

import java.util.Scanner;

public class b_25304 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int totalPrice = sc.nextInt();
    int count = sc.nextInt();
    int sum = 0;
    for (int i = 0; i < count; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      sum += a * b;
    }
    if(totalPrice == sum) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
