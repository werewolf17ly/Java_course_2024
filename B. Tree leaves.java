import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> input = new ArrayList<>();
    while (scanner.hasNextInt()) {
      int number = scanner.nextInt();
      if (number == 0) {
        break;
      }
      input.add(number);
    }
    Node root = new Node(input.get(0));
    for (int i = 1; i < input.size(); i++) {
      insert(root, input.get(i));
    }
    List<Integer> leaves = new ArrayList<>();
    getLeaves(root, leaves);
    Collections.sort(leaves);
    for (int leaf : leaves) {
      System.out.print(leaf + " ");
    }
  }

  private static void getLeaves(Node node, List<Integer> leaves) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      leaves.add(node.value);
      return;
    }
    getLeaves(node.left, leaves);
    getLeaves(node.right, leaves);
  }

  private static void insert(Node node, int value) {
    if (value < node.value) {
      if (node.left == null) {
        node.left = new Node(value);
      } else {
        insert(node.left, value);
      }
    } else if (value > node.value) {
      if (node.right == null) {
        node.right = new Node(value);
      } else {
        insert(node.right, value);
      }
    }
  }

  private static class Node {

    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
      this.value = value;
    }
  }
}