/**
 * Created by Jack.Yang on 7/1/2015.
 */

import java.util.*;
public class OddEvenTree {

    public int[] getTree(String[] x) {
        int[] invalid = new int[1];
        invalid[0] = -1;
        int n = x.length;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            char[] line = x[i].toCharArray();
            for (int j = 0; j < n; ++j)
                map[i][j] = line[j] == 'E' ? 0 : 1;
        }
        if (map[0][0] == 1) return invalid;
        boolean[] result = new boolean[n];
        result[0] = true;
        for (int i = 1; i < n; ++i)
            result[i] = map[0][i] == 0;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    if (map[i][j] == 1) return invalid;
                    continue;
                }
                if ((result[i] == result[j]) ==  (map[i][j] == 1)) return invalid;
            }
        }

        int[] ret = new int[2 * n - 2];
        int curr = 0;
        for (int i = 1; i < n; ++i) {
            if (!result[i]) {
                ret[curr++] = 0;
                ret[curr++] = i;
            }
        }

        for (int i = 1; i < n; ++i) {
            if (!result[i]) {
                for (int j = 1; j < n; ++j) {
                    if (result[j]) {
                        ret[curr++] = i;
                        ret[curr++] = j;
                    }
                }
                System.out.println(curr);
                return ret;
            }
        }



        return invalid;
    }
}
