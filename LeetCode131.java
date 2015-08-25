import java.util.*;

public class LeetCode131 {
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        if (s == null) return null;
        result = new ArrayList<>();
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (ch[i] == ch[j] && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        solve(isPalindrome, 0, n, s, new ArrayList<String>());

        return result;
    }

    private void solve(boolean[][] isPalindrome, int start, int end, String s, List<String> curr) {

        if (start == end) {
            result.add(curr);
            return;
        }

        for (int i = start; i < end; ++i) {
            if (isPalindrome[start][i]) {
                curr.add(s.substring(start, i + 1));
                solve(isPalindrome, i + 1, end, s, curr);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        new LeetCode131().partition("a");
    }
}