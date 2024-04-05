package algorithm.basic.one.data.structure.one;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class b_1406_doubled_linkedlist {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    LinkedList<Character> editor = new LinkedList<>();
    // ListIterator 인터페이스가 커서 역할을 해준다.
    ListIterator<Character> cursor = editor.listIterator();

    for (char c : input.toCharArray()) {
      // 문자를 넣고 커서는 다음을 가리키게 된다. ex) (cursor), 0 -> 1, (cursor), 0
      // 만약에 cursor.add(c); 대신에 editor.add(c); 를 쓰게 된다면 커서 위치는
      // ex) (cursor), a, b, c, d 가 된다. 따라서 상황에 맞게 잘 써야한다.
      cursor.add(c);
    }

    int M = Integer.parseInt(br.readLine());

    while (M-- > 0) {
      String[] command = br.readLine().split(" ");
      char op = command[0].charAt(0);

      switch (op) {
        case 'L':
          if (cursor.hasPrevious()) {
            // 커서를 왼쪽으로 이동시킨다.
            cursor.previous();
          }
          break;
        case 'D':
          if (cursor.hasNext()) {
            // 커서를 오른쪽으로 이동시킨다.
            cursor.next();
          }
          break;
        case 'B':
          if (cursor.hasPrevious()) {
            cursor.previous();
            // 가장 마지막으로 next()나 previous()로 반환된 요소를 리스트에서 삭제한다.
            // 즉 remove() 를 사용하려면 먼저 next()나 previous() 를 사용해야 한다.
            cursor.remove();
          }
          break;
        case 'P':
          cursor.add(command[1].charAt(0));
          break;
      }
    }

    for (Character c : editor) {
      bw.write(c);
    }

    br.close();
    bw.flush();
    bw.close();
  }
}
