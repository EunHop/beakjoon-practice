package stage_4;

import java.util.Scanner;

public class b_10811 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int a=0; a<n; a++) {
      arr[a] = a+1;
    }
    int m = sc.nextInt();
    for(int b=0; b<m; b++) {
      int i = sc.nextInt()-1;
      int j = sc.nextInt()-1;
      while(i<j) {
        int temp=arr[i];
        arr[i++]=arr[j];
        arr[j--] = temp;
      }
    }
    sc.close();

    for(int result:arr) {
      System.out.print(result+" ");
    }
  }
}
