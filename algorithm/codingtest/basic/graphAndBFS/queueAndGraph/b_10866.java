package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

// 이중 연결리스트로 데크(Deque) 구현 https://st-lab.tistory.com/187

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_10866 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    MyDeque mD = new MyDeque();
    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      switch (str[0]) {
        case "push_front":
          mD.push_front(Integer.parseInt(str[1]));
          break;
        case "push_back":
          mD.push_back(Integer.parseInt(str[1]));
          break;
        case "pop_front":
          sb.append(mD.pop_front()).append("\n");
          break;
        case "pop_back":
          sb.append(mD.pop_back()).append("\n");
          break;
        case "size":
          sb.append(mD.size()).append("\n");
          break;
        case "empty":
          sb.append(mD.empty()).append("\n");
          break;
        case "front":
          sb.append(mD.front()).append("\n");
          break;
        case "back":
          sb.append(mD.back()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

  public static class MyDeque {
    int size;
    Node head;
    Node tail;

    public MyDeque() {
      this.size = 0;
    }

    public void push_front(int X) {
      Node newNode = new Node(X);
      if (head != null) {
        newNode.next = head;
        head.prev = newNode;
      }
      head = newNode;
      size++;
      if(size == 1) {
        tail = head;
      }
    }

    public void push_back(int X) {
      Node newNode = new Node(X);
      if (tail != null) {
        newNode.prev = tail;
        tail.next = newNode;
      }
      tail = newNode;
      size++;
      if(size == 1) {
        head = tail;
      }
    }
    public int pop_front() {
      if (size == 0) {
        return -1;
      } else {
        int val = head.value;
        head = head.next;
        size--;
        return val;
      }
    }

    public int pop_back() {
      if (size == 0) {
        return -1;
      } else {
        int val = tail.value;
        tail = tail.prev;
        size--;
        return val;
      }
    }

    public int size() {
      return size;
    }

    public int empty() {
      if (size == 0) {
        return 1;
      } else {
        return 0;
      }
    }

    public int front() {
      if (size == 0) {
        return -1;
      } else {
        return head.value;
      }
    }

    public int back() {
      if (size == 0) {
        return -1;
      } else {
        return tail.value;
      }
    }
  }

  public static class Node {
    int value;
    Node prev;
    Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
