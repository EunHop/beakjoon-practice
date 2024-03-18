package algorithm.codingtest.basic.graphAndBFS.queueAndGraph;

// 연결 리스트로 큐 구현 https://st-lab.tistory.com/184

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10845 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    myQueue mq = new myQueue();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String str = st.nextToken();
      switch (str) {
        case "push":
          int X = Integer.parseInt(st.nextToken());
          mq.push(X);
          break;
        case "pop":
          sb.append(mq.pop()).append("\n");
          break;
        case "size":
          sb.append(mq.size()).append("\n");
          break;
        case "empty":
          sb.append(mq.empty()).append("\n");
          break;
        case "front":
          sb.append(mq.front()).append("\n");
          break;
        case "back":
          sb.append(mq.back()).append("\n");
          break;
      }
    }
    System.out.println(sb);
  }

  public static class myQueue {
    int size;
    Node head;
    Node tail;

    myQueue() {
      this.size = 0;
    }

    public void push(int X) {
      Node newNode = new Node(X, null);
      if (size == 0) {
        head = newNode;
      } else {
        tail.next = newNode;
      }
      tail = newNode;
      size++;
    }

    public int pop() {
      if (size == 0) {
        return -1;
      } else {
        int val = head.val;
        head = head.next;
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
        return head.val;
      }
    }

    public int back() {
      if (size == 0) {
        return -1;
      } else {
        return tail.val;
      }
    }
  }

  public static class Node {
    int val;
    Node next;

    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }
  }
}
