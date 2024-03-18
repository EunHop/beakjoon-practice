package stage_4;

import java.util.Arrays;
import java.util.Scanner;

public class b_3052 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] arr = new int[10];
    for(int i=0; i<10; i++) {
      int a = scan.nextInt();
      int rest = a % 42;
      arr[i] = rest;
    }
    long count = Arrays.stream(arr).distinct().count();
    System.out.println(count);
  }
}
