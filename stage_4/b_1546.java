package stage_4;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class b_1546 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int[] sbj = new int[a];
    for(int i=0; i<a; i++) {
      sbj[i] = scan.nextInt();
    }
    int max = Arrays.stream(sbj).max().orElseThrow(NoSuchElementException::new);
    double sum = 0;
    for(int j=0; j< sbj.length; j++) {
      double operation = ((double) sbj[j]/max)*100;
      sum += operation;
    }
    System.out.println(sum/a);
  }
}
