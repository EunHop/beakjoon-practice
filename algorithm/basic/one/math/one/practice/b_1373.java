package algorithm.basic.one.math.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.
public class b_1373 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String binaryNum = br.readLine();
    for(int i=0; i<binaryNum.length()%3; i++) {
      binaryNum = "0" + binaryNum;
    }
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<binaryNum.length(); i+=3) {
      String num = String.valueOf((binaryNum.charAt(i)-'0')*4+(binaryNum.charAt(i+1)-'0')*2+(binaryNum.charAt(i+2)-'0'));
      sb.append(num);
    }
    System.out.println(sb.toString());
  }
}
