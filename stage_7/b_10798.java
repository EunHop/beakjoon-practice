package stage_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_10798 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[][] arr = new char[5][15];
    for (int y = 0; y < 5; y++) {
      String line = br.readLine();
      for(int x=0; x<line.length(); x++) {
        arr[y][x] = line.charAt(x);
      }
    }
    for(int i=0; i<15; i++) {
      for(int j=0; j<5; j++) {
        if(arr[j][i]==0) {
          continue;
        }
        System.out.print(arr[j][i]);
      }
    }
  }
}
