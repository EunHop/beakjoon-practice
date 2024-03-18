package algorithm.basic.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10828 {
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Stack stack = new Stack();
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String str = st.nextToken();
      switch (str) {
        case "push" :
          int num = Integer.parseInt(st.nextToken());
          stack.push(num);
          break;
        case "pop" :
          stack.pop();
          break;
        case "size" :
          stack.size();
          break;
        case "empty" :
          stack.empty();
          break;
        case "top" :
          stack.top();
          break;
      }
    }
    System.out.println(sb);
  }
  public static class Stack {
    int size;
    Node top;
    public Stack() {
      this.size=0;
      this.top=null;
    }
    public void push(int num) {
      Node newNode = new Node(num, null);
      if (size != 0) {
        newNode.next = top;
      }
      top = newNode;
      size++;
    }
    public void pop() {
      if(size==0) {
        sb.append(-1).append("\n");
      } else {
        int topData = top.data;
        top = top.next;
        size--;
        sb.append(topData).append("\n");
      }
    }
    public void size() {
      sb.append(size).append("\n");
    }
    public void empty() {
      if (size==0) {
        sb.append(1).append("\n");
      } else {
        sb.append(0).append("\n");
      }
    }
    public void top() {
      if(size==0) {
        sb.append(-1).append("\n");
      } else {
        sb.append(top.data).append("\n");
      }
    }
  }
  public static class Node {
    int data;
    Node next;
    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
