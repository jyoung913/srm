/**
 * Created by Jack.Yang on 6/30/2015.
 */
public class Privateparty {
    final double eps = 10e-9;

    public double getexp(int[] a) {
        int n = a.length;
        if (n == 1) return 1d;
        double result = 0d;
        double[][] dp = new double[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][0] = 1d;

        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (a[j] != j) {
                    double acc;
                    if (a[a[j]] == j || a[a[j]] == a[j]) {
                        acc = 1.0 - (double)i / (n - 1);
                    } else {
                        double real = 0d;
                        for (int k = 0; k < i; ++k) {
                            double cur = dp[a[j]][k];
                            if (k > 0) cur -= dp[a[j]][k - 1] * (k - 1) / k;
                            real += cur * (n - k + 1) / n;
                        }
                        acc = 1.0 - real * i / (n - 1);
                    }
                    dp[j][i] = acc / (i + 1) + dp[j][i - 1] * i / (i + 1);
                } else {
                    dp[j][i] = 1d;
                }
            }
        }

        for (int i = 0; i < n; ++i)
            result += dp[i][n - 1];

        return result;
    }



}
