/**
 * Created by Jack.Yang on 10/22/2015.
 */
public class Foobar2 {
        static int[][] result;
        static int m, n;
        public static int[][] answer(int[][] population, int x, int y, int strength) {
            m = population.length;
            n = population[0].length;
            result = new int[m][n];
            for (int i = 0; i < m; ++i)
                for (int j = 0; j < n; ++j)
                    result[i][j] = population[i][j];


            dfs(x, y, strength);

            return result;

        }

        static void dfs(int x, int y, int strength) {
            // visited
            if (result[x][y] == -1) return;
            // cannot infect
            if (strength < result[x][y]) return;
            // can infect
            result[x][y] = -1;
            if (x < m - 1) dfs(x + 1, y, strength);
            if (x > 0) dfs(x - 1, y, strength);
            if (y < n - 1) dfs(x, y + 1, strength);
            if (y > 0) dfs(x, y - 1, strength);
        }
}
