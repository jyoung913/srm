/**
 * Created by Jack.Yang on 6/30/2015.
 */
import java.sql.Array;
import java.util.*;
public class ApplesAndOrangesEasy {
    public int maximumApples(int N, int K, int[] info) {
        int maxPerInterval = K >> 1;
        if(info == null || info.length < 1) {
            int numInterval = N / K;
            return maxPerInterval * numInterval + Math.min(N % K, maxPerInterval);
        }
        int[] apple = new int[N];
        Arrays.fill(apple, 0);
        for (int i = 0; i < info.length; ++i) {
            apple[info[i] - 1] = 1;
        }

        for (int i = 0; i < N; ++i) {
            if (apple[i] == 1) continue;
            int curr = 0;
            int left = 1 - K + i;
            int right = i;
            for(int j = left; j <= right; ++j)
                if (j >= 0 && j < N)
                    curr += apple[j];
            boolean canBeApple = true;
            while (left <= i) {
                if (curr >= maxPerInterval) {
                    canBeApple = false;
                    break;
                }
                ++right;
                if (right < N)
                    curr += apple[right];
                if (right - left + 1 > K) {
                    ++left;
                    if (left >= 0 && left < N)
                        curr -= apple[left];
                }
            }
            if (!canBeApple) continue;
            apple[i] = 1;
            ++curr;
        }
        int result = 0;
        for (int i = 0; i < N; ++i){

            result += apple[i];
        }
        return result;
    }
}
