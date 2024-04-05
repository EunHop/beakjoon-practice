package algorithm.basic.one.data.structure.one.reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_10820 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str="";
    // while(!(str = br.readLine()).isEmpty()) 는 비어있는지 확인할 수 있지만 NullPointerException 이 떨어진다.
    // Null 체크로 확인해야한다.
    while ((str = br.readLine())!=null) {
      StringBuilder sb = new StringBuilder();
      // lowercase, uppercase, number, space
      int[] arr = new int[4];
      for(int i=0; i<str.length(); i++) {
        if(str.charAt(i)>='a' && str.charAt(i)<='z') {
          arr[0]++;
        }
        else if(str.charAt(i)>='A' && str.charAt(i)<='Z') {
          arr[1]++;
        }
        else if(str.charAt(i)==' ') {
          arr[3]++;
        }
        // 소문자, 대문자, 공백이 아니면 숫자로 간주하고 처리한다.
        else {
          arr[2]++;
        }
      }
      for(int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      System.out.print(sb);
    }
  }
}
