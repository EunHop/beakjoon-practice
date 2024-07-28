package algorithm.basic.two.tree.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 트리 순회
 * 이진 트리를 구현한다.
 */
public class b_1991 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N =  Integer.parseInt(br.readLine());
    BinaryTree tree = new BinaryTree();
    for(int i=0; i<N; i++) {
      String[] nodes = br.readLine().split(" ");
      char parent = nodes[0].charAt(0);
      char left = nodes[1].charAt(0);
      char right = nodes[2].charAt(0);
      tree.addNode(parent, left, right);
    }
    tree.preorderTraversal(tree.root);
    System.out.println();

    tree.inorderTraversal(tree.root);
    System.out.println();

    tree.postorderTraversal(tree.root);
    System.out.println();
  }

  static class Node {
    char value;
    Node leftNode, rightNode;

    public Node(char value) {
      this.value = value;
    }
  }

  static class BinaryTree {
    Node root;

    public void addNode(char parent, char left, char right) {
      if(root==null) {
        root = new Node(parent);
        if(left != '.') root.leftNode = new Node(left);
        if(right != '.') root.rightNode = new Node(right);
      } else addNodeChild(root, parent, left, right);
    }

    public void addNodeChild(Node current, char parent, char left, char right) {
      if(current==null) return;
      if(current.value == parent) {
        if(left != '.') current.leftNode = new Node(left);
        if(right != '.') current.rightNode = new Node(right);
      } else {
        addNodeChild(current.leftNode, parent, left, right);
        addNodeChild(current.rightNode, parent, left, right);
      }
    }

    public void preorderTraversal(Node node) {
      if(node != null) {
        System.out.print(node.value);
        preorderTraversal(node.leftNode);
        preorderTraversal(node.rightNode);
      }
    }

    public void inorderTraversal(Node node) {
      if(node != null) {
        inorderTraversal(node.leftNode);
        System.out.print(node.value);
        inorderTraversal(node.rightNode);
      }
    }

    public void postorderTraversal(Node node) {
      if(node != null) {
        postorderTraversal(node.leftNode);
        postorderTraversal(node.rightNode);
        System.out.print(node.value);
      }
    }
  }
}
