/**
 * Created by Jack.Yang on 6/30/2015.
 */
public class Coversta {
    public int place(String[] a, int[] x, int[] y) {
        int n = a.length;
        int m = a[0].length();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = a[i].charAt(j) - '0';
        int[][] val = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j) {
                val[i][j] = 0;
                for (int k = 0; k < x.length; ++k) {
                    if (i + x[k] >= 0 && i + x[k] < n &&
                            j + y[k] >= 0 && j + y[k] < m) {
                        val[i][j] += map[i + x[k]][j + y[k]];
                    }
                }
            }
        int max = Integer.MIN_VALUE;
        for (int x1 = 0; x1 < n; ++x1)
            for (int y1 = 0; y1 < m; ++y1)
                for (int x2 = 0; x2 < n; ++x2)
                    for (int y2 = 0; y2 < m; ++y2) {
                        if ((x1 == x2) && (y1 == y2)) continue;
                        int result = val[x1][y1] + val[x2][y2];
                        if (result <= max) continue;
                        if (x.length > 1)
                            for (int i = 0; i < x.length - 1; ++i)
                                for (int j = i + 1; j < x.length; ++j)
                                    if (((x1 + x[i]) == (x2 + x[j])) && ((y1 + y[i]) == (y2 + y[j])))
                                        if (((x1 + x[i]) < n) &&
                                                ((x1 + x[i]) >= 0) &&
                                                ((y1 + y[i]) < m) &&
                                                ((y1 + y[i]) >= 0))
                                                    result -= map[i][j];

                        max = Math.max(max, result);
                    }


        return max;
    }

}
