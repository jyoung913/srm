/**
 * Created by Jack.Yang on 6/30/2015.
 */
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;

public class MissingLCM {
    public int getMin(int N) {
        if (N < 1) return 0;
        if (N == 1) return 2;
        int result = N - 1;

        int[] tmp = new int[N];

        for (int i = 0; i < N; ++i) {
            tmp[i] = N + i + 1;
        }

        for (;result > 0; --result) {
            if (tmp[result] != N + result + 1) return N + result + 1;
            ArrayList<Integer> seg = dec(result + 1);
            for(int i : seg) {
                boolean found = false;
                for(int j = 0; j < result; ++j) {
                    if (tmp[j] % i == 0) {
                        found = true;
                        tmp[j] /= i;
                        break;
                    }
                }
                if (!found) return N + result + 1;
            }
        }
        return 0;
    }

    private ArrayList<Integer> dec(int x) {
        if (x <= 1) {
            return new ArrayList<Integer>();
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 2; i < x; ++i) {
            while (x != i) {
                if (x % i == 0) {
                    x /= i;
                    result.add(i);
                } else {
                    break;
                }
            }
        }
        if (x != 1)  result.add(x);
        return result;
    }
}
