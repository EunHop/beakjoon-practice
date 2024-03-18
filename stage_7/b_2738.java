package stage_7;

import java.util.Scanner;

public class b_2738 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[][] Aarr = new int[m][n];
    for(int i=0; i<m; i++) {
      for(int j=0; j<n; j++) {
        Aarr[i][j] = scan.nextInt();
      }
    }
    for(int i=0; i<m; i++) {
      for(int j=0; j<n; j++) {
        Aarr[i][j] = Aarr[i][j] + scan.nextInt();
      }
    }
    for(int i=0; i<m; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(Aarr[i][j]);
        if(j<n-1) {
          System.out.print(" ");
        }
      }
      if(i<m-1) {
        System.out.println();
      }
    }
  }
}
