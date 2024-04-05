package stage_5;

import java.util.Scanner;
import java.util.StringTokenizer;

public class b_1152 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String sentence = scan.nextLine();
    scan.close();
    StringTokenizer st = new StringTokenizer(sentence, " ");
    System.out.println(st.countTokens());
  }
}
