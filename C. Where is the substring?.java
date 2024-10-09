import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String pattern = scanner.nextLine();
    String text = scanner.nextLine();

    List<Integer> occurrences = new ArrayList<>();
    int[] prefix = computePrefixFunction(pattern);
    int j = 0;
    for (int i = 0; i < text.length(); i++) {
      while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
        j = prefix[j - 1];
      }
      if (text.charAt(i) == pattern.charAt(j)) {
        j++;
      }
      if (j == pattern.length()) {
        occurrences.add(i - j + 1);
        j = prefix[j - 1];
      }
    }

    for (Integer occurrence : occurrences) {
      System.out.print(occurrence + " ");
    }
  }

  private static int[] computePrefixFunction(String pattern) {
    int[] prefix = new int[pattern.length()];
    prefix[0] = 0;
    int k = 0;
    for (int i = 1; i < pattern.length(); i++) {
      while (k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
        k = prefix[k - 1];
      }
      if (pattern.charAt(i) == pattern.charAt(k)) {
        k++;
      }
      prefix[i] = k;
    }
    return prefix;
  }
}