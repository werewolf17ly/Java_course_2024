import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int n = Integer.parseInt(tokenizer.nextToken());
    int[] a = new int[n];
    tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(tokenizer.nextToken());
    }
    int[] dp = new int[n];
    int[] prev = new int[n];
    int maxLen = 1;
    int maxIndex = 0;
    dp[0] = 1;
    prev[0] = -1;
    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      prev[i] = -1;
      for (int j = 0; j < i; j++) {
        if (a[i] <= a[j] && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          prev[i] = j;
        }
      }
      if (dp[i] > maxLen) {
        maxLen = dp[i];
        maxIndex = i;
      }
    }
    System.out.println(maxLen);
    StringBuilder sb = new StringBuilder();
    while (maxIndex != -1) {
      sb.append(maxIndex + 1).append(" ");
      maxIndex = prev[maxIndex];
    }
    System.out.println(sb.reverse().toString().trim());
  }
}