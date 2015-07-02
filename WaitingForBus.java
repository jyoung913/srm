import java.util.Arrays;

/**
 * Created by Jack.Yang on 7/2/2015.
 */
public class WaitingForBus {
    public double whenWillBusArrive(int[] time, int[] prob, int s) {
        int n = time.length;
        int maxlen = 222223;
        double eps = 1e-9;
        double[] dp = new double[maxlen];
        Arrays.fill(dp, 0d);
        dp[0] = 1d;
        for (int i = 0; i < s; ++i) {
            if (dp[i] == 0) continue;
            for (int j = 0; j < n; ++j)
                if (i + time[j] < maxlen)
                    dp[i + time[j]] += dp[i] * (double) prob[j] / 100d;
        }
        double ret = 0;
        for (int i = s; i < maxlen; ++i)
            if (dp[i] >= 0) ret += (double) dp[i] * (double)(i - s);
        return ret;
    }
}
