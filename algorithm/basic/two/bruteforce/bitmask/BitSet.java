package algorithm.basic.two.bruteforce.bitmask;

public class BitSet {
  private int A;
  public BitSet() {
    this.A = 0;
  }
  // 요소 추가
  public void add(int element) {
    if (element >= 0 && element < 32) { // 비트 위치가 유효한지 확인
      A |= (1 << element);
    } else {
      System.out.println("Element out of range");
    }
  }

  // 요소 제거
  public void remove(int element) {
    if (element >= 0 && element < 32) { // 비트 위치가 유효한지 확인
      A &= ~(1 << element);
    } else {
      System.out.println("Element out of range");
    }
  }

  // 요소 포함 여부 확인
  public boolean contains(int element) {
    if (element >= 0 && element < 32) { // 비트 위치가 유효한지 확인
      return (A & (1 << element)) != 0;
    } else {
      return false;
    }
  }

  // A의 n번째 비트 반전
  public void reverseNthBit(int element) {
    if (element >= 0 && element < 32) { // 비트 위치가 유효한지 확인
      A ^= (1 << element);
    } else {
      System.out.println("Element out of range");
    }
  }
  // 집합 출력
  public void printSet() {
    System.out.print("{ ");
    for (int i = 0; i < 32; i++) {
      if ((A & (1 << i)) != 0) {
        System.out.print(i + " ");
      }
    }
    System.out.println("}");
  }

  // 집합의 크기 구하기
  public int size() {
    // Integer.bitCount 를 사용하여 비트가 1인 개수를 반환
    return Integer.bitCount(A);
  }

  // 최소 원소 찾기
  public int findMin() {
    // 비어있으면 -1 반환
    if (A == 0) {
      return -1;
    }
    // 가장 오른쪽 1 비트 찾기
    int minBit = A & -A;
    return Integer.numberOfTrailingZeros(minBit); //최소 원소의 인덱스를 반환
  }

  // 최소 원소 지우기
  public void removeMin() {
    if (A != 0) {
      A &= (A - 1); // 가장 오른쪽 1 비트 제거
    }
  }

  // 모든 부분 집합 순회하기
  public void traverseSubsets() {
    System.out.println("All subsets:");
    for (int subset = A; subset != 0; subset = (subset - 1) & A) {
      printSubset(subset);
    }
    printSubset(0); // 공집합 출력
  }

  // 부분 집합 출력
  private void printSubset(int subset) {
    System.out.print("{ ");
    for (int i = 0; i < 32; i++) {
      if ((subset & (1 << i)) != 0) {
        System.out.print(i + " ");
      }
    }
    System.out.println("}");
  }

  // 합집합
  public BitSet union(BitSet other) {
    BitSet result = new BitSet();
    result.A = this.A | other.A;
    return result;
  }

  // 교집합
  public BitSet intersection(BitSet other) {
    BitSet result = new BitSet();
    result.A = this.A & other.A;
    return result;
  }

  // 차집합
  public BitSet difference(BitSet other) {
    BitSet result = new BitSet();
    result.A = this.A & ~other.A;
    return result;
  }

  // XOR 집합 (A와 B 중 하나에만 포함된 원소)
  public BitSet symmetricDifference(BitSet other) {
    BitSet result = new BitSet();
    result.A = this.A ^ other.A;
    return result;
  }

  public static void main(String[] args) {
    BitSet set = new BitSet();

    // 요소 추가
    set.add(1);
    set.add(3);
    set.add(5);
    set.add(7);
    // 요소 제거
    set.remove(5);

    // 집합 출력
    System.out.print("Set: ");
    set.printSet();

    // 집합의 크기 구하기
    System.out.println("Size: " + set.size());

    // 요소 포함 여부 확인
    System.out.println("7을 포함하고 있나요? :" + set.contains(7));
    // A의 n번째 비트 반전
    System.out.println("set의 5번째 요소를 반전시킵니다.");
    set.reverseNthBit(5);
    System.out.println("5를 포함하고 있나요? :" + set.contains(5));

    // 최소 원소 찾기
    System.out.println("Min element: " + set.findMin());

    // 최소 원소 지우기
    set.removeMin();
    System.out.print("Set after removing min: ");
    set.printSet();

    // 모든 부분 집합 순회하기
    set.traverseSubsets();

    BitSet set2 = new BitSet();
    set2.add(3);
    set2.add(4);
    set2.add(5);

    // 집합 출력
    System.out.print("Set: ");
    set.printSet();
    System.out.print("Set2: ");
    set2.printSet();

    // 합집합
    System.out.print("set, set2 Union: ");
    set.union(set2).printSet();

    // 교집합
    System.out.print("set, set2 Intersection: ");
    set.intersection(set2).printSet();

    // 차집합
    System.out.print("Difference (set - set2): ");
    set.difference(set2).printSet();

    // XOR 집합
    System.out.print("set, set2 Symmetric Difference: ");
    set.symmetricDifference(set2).printSet();
  }
}
