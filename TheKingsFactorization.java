/**
 * Created by Jack.Yang on 7/2/2015.
 */

import java.util.*;
public class TheKingsFactorization {
    public long[] getVector(long N, long[] primes) {
        ArrayList<Long> ans = new ArrayList<Long>();

            for (int i = 0; i < primes.length; ++i) {
                N /= primes[i];
                ans.add(primes[i]);
            }
            for (long i = 2; i < Math.min(1000000, N); i += 2) {
                if (N % i == 0)
                    do {
                        ans.add(i);
                        N /= i;
                    } while (N % i == 0);
                if(i == 2) i = 1;
            }


        if (N != 1) {
            ans.add(N);
        }
        long[] ret = ans.stream().mapToLong(l -> l).toArray();
        Arrays.sort(ret);
        return ret;

    }
}
