/**
 * Created by Jack.Yang on 8/20/2015.
 */

import java.util.*;

public class LuckySum {


        public static void main(String[] args) {
            String s = "aacecaaa";
            String w = s + (new StringBuilder(s).reverse().toString());
            int n = s.length();
            int[] prefix = new int[w.length()];
            Arrays.fill(prefix, 0);
            prefix[0] = 0;
            for (int i = n; i < w.length(); ++i) {
                int pos = prefix[i - 1];
                while (w.charAt(pos) != w.charAt(i) && pos > 0) {
                    pos = prefix[pos - 1];
                }
                if (w.charAt(pos) == w.charAt(i)) {
                    prefix[i] = pos + 1;
                }
                System.out.print(prefix[i] + " ");
            }


        }

    public long construct(String note) {
        int n = note.length();
        if (n < 1) return -1;
        if (n == 1) return 8;
        char[] chars = new StringBuilder(note).reverse().toString().toCharArray();
        long[][][][] dp = new long[n][2][2][2];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++i) {
                    for (int l = 0; l < 2; ++l) {
                        dp[i][j][k][l] = Integer.MAX_VALUE;
                    }
                }
            }
        }


        if (chars[0] == '?') {
            // single digit zero not allowed
            dp[0][0][0][0] = 8;
            dp[0][1][0][0] = 1;
        } else if (chars[0] == '1') {
            dp[0][1][0][0] = 1;
        } else if (chars[0] == '4') {
            dp[0][1][0][0] = 4;
        } else if (chars[0] == '8') {
            dp[0][0][0][0] = 8;
        } else {
            return -1;
        }


        for (int i = 1; i < n; ++i) {

            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2; ++i) {
                    for (int l = 0; l < 2; ++l) {

                    }
                }
            }
        }

        return -1;
    }
}
