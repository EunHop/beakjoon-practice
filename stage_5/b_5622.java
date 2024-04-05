package stage_5;

import java.util.Scanner;

public class b_5622 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String word = scan.next();
    int count = 0;
    for(int i=0; i<word.length(); i++) {
      char a = word.charAt(i);
      if(a =='A' || a=='B' || a=='C') {
        count+=3;
      }
      else if(a =='D' || a=='E' || a=='F') {
        count+=4;
      }
      else if(a =='G' || a=='H' || a=='I') {
        count+=5;
      }
      else if(a =='J' || a=='K' || a=='L') {
        count+=6;
      }
      else if(a =='M' || a=='N' || a=='O') {
        count+=7;
      }
      else if(a =='P' || a=='Q' || a=='R' || a =='S') {
        count+=8;
      }
      else if(a =='T' || a=='U' || a=='V') {
        count+=9;
      }
      else if(a =='W' || a=='X' || a=='Y' || a=='Z') {
        count+=10;
      }
    }
    System.out.println(count);
  }
}
