/**
 * Created by Jack.Yang on 7/2/2015.
 */
import java.util.*;
public class OkonomiyakiParty {
    public int count(int[] osize, int M, int K) {
        int mod = 1000000007;
        Arrays.sort(osize);

        // starting at position i, how many in total has interval <= K
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < osize.length; ++i) {
            int len = 0;
            while (i + (++len) - 1 < osize.length) {
                if (osize[i + len - 1] - osize[i] > K) {
                    break;
                }
            }
            list.add(len - 1);
        }

        //  value: C(key, M) % mod
        HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();

        int result = 0;
        for(int len: list) {
            if (len < M) continue;
            System.out.println(len + " " + M);
            if (!ans.containsKey(len)) ans.put(len, combinations(len, M, mod));
            result += ans.get(len);
            result %= mod;
        }
        return result;
    }
    private int get_degree(int n, int p) { // returns the degree with which p is in n!
        int degree_num = 0;
        int u = p;
        int temp = n;
        while (u <= temp) {
            degree_num += temp/u;
            u *= p;
        }
        return degree_num;
    }

    private int combinations(int n, int k, int p) {
        int num_degree = get_degree(n,p) - get_degree(n- k,p);
        int den_degree = get_degree(k,p);
        if (num_degree > den_degree) {
            return 0;
        }
        int res = 1;
        for (int i = n; i > n- k; --i) {
            int ti = i;
            while(ti % p == 0) {
                ti /= p;
            }
            res = (res *ti)%p;
        }
        int denom = 1;
        for (int i = 1; i <= k; ++i) {
            int ti = i;
            while(ti % p == 0) {
                ti /= p;
            }
            denom = (denom * ti)%p;
        }
        res = (res * degree(denom, p-2, p)) % p;
        return res;
    }

    private int degree(int a, int k, int p) {
        int res = 1;
        int cur = a;

        while (k > 0) {
            if (k%2 == 1) {
                res = (res * cur)%p;
            }
            k /= 2;
            cur = (cur * cur) % p;
        }
        return res;
    }
}
