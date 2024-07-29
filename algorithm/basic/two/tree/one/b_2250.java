package algorithm.basic.two.tree.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 트리의 높이와 너비
 */
public class b_2250 {
  static Node[] tree;
  // xPos 변수는 중위순회 돌면서 해당 노드의 수평 위치를 기록합니다.
  // 이 변수로 인해 levelMin[], levelMax[] 에 각 레벨에 최소, 최대 위치를 기록하며 거리를 계산할 수 있게 됩니다.
  static int N, xPos = 1;
  static int[] levelMin, levelMax;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    tree = new Node[N+1];
    for(int i=1; i<=N; i++) {
      tree[i] = new Node(i);
    }
    for(int i=0; i<N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int data = Integer.parseInt(st.nextToken());
      int left = Integer.parseInt(st.nextToken());
      int right = Integer.parseInt(st.nextToken());
      if(left != -1) tree[data].left = tree[left];
      if(right != -1) tree[data].right = tree[right];
    }
    int root = findRoot();

    levelMin = new int[N+1];
    levelMax = new int[N+1];
    Arrays.fill(levelMin, Integer.MAX_VALUE);
    inorderDFS(root, 1);

    int maxWidth = 0;
    int level = 1;
    for(int i=1; i<=N; i++) {
      if(levelMin[i] != Integer.MAX_VALUE) {
        int width = levelMax[i] - levelMin[i] + 1;
        if(width > maxWidth) {
          maxWidth = width;
          level = i;
        }
      }
    }
    System.out.println(level+" "+maxWidth);
  }
  static class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
      this.data = data;
    }
  }
  public static int findRoot() {
    boolean[] isNotRoot = new boolean[N+1];
    for(int i=1; i<=N; i++) {
      if(tree[i].left != null) isNotRoot[tree[i].left.data] = true;
      if(tree[i].right != null) isNotRoot[tree[i].right.data] = true;
    }
    for(int i=1; i<=N; i++) {
      if(!isNotRoot[i]) return i;
    }
    return -1;
  }

  public static void inorderDFS(int node, int level) {
    if(node == -1) return;
    inorderDFS(tree[node].left != null ? tree[node].left.data : -1, level+1);
    levelMin[level] = Math.min(levelMin[level], xPos);
    levelMax[level] = Math.max(levelMax[level], xPos);
    xPos++;
    inorderDFS(tree[node].right != null ? tree[node].right.data : -1, level+1);
  }
}
