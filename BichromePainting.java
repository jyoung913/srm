/**
 * Created by Jack.Yang on 7/2/2015.
 */
public class BichromePainting {
    public String isThatPossible(String[] board, int k) {
        if (k == 1) return "Possible";
        int n = board.length;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                map[i][j] = board[i].charAt(j) == 'W' ? 0 : 1;
            }
        }

        while (true) {
            boolean found = false;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (map[i][j] == 1) found = true;
                }
                if (found) break;
            }
            if (!found) return "Possible";
            found = true;
            for (int i = 0; i < n - k + 1; ++i) {
                for (int j = 0; j < n - k + 1; ++j) {
                    found = true;
                    int color = 2;
                    for (int a = 0; a < k; ++a) {
                        for (int b = 0; b < k; ++b) {
                            if (color == 2 && map[i + a][j + b] != 2) {
                                color = map[i + a][j + b];
                            }
                            if (color == 1 - map[i + a][j + b]) {
                                found = false;
                                break;
                            }
                        }
                        if (!found) break;
                    }
                    if (found) {
                        if (color == 2) {
                            found = false;
                        } else {
                            for (int a = 0; a < k; ++a) {
                                for (int b = 0; b < k; ++b) {
                                    map[i + a][j + b] = 2;
                                }
                            }
                            break;
                        }
                    }
                }
                if (found) break;
            }
            if (!found) return "Impossible";
        }
    }
}
