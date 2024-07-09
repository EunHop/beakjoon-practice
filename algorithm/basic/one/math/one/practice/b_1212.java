package algorithm.basic.one.math.one.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8진수가 주어졌을 때, 2진수로 변환하는 프로그램을 작성하시오.
public class b_1212 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String octalNum = br.readLine();
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<octalNum.length(); i++) {
      StringBuilder temp = new StringBuilder(Integer.toBinaryString(octalNum.charAt(i) - '0'));
      if(i!=0) {
        for (int j = 0; j < temp.length() % 3; j++) {
          temp.insert(0, "0");
        }
      }
      sb.append(temp);
    }
    System.out.println(sb.toString());
  }
}
