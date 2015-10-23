import java.util.Arrays;

/**
 * Created by Jack.Yang on 10/22/2015.
 */
public class foobar31 {
    static class Minion implements Comparable<Minion> {
        public double ratio;
        public int time;
        public int index;

        Minion(int min, int a, int b, int index) {
            this.ratio =  (double)b / (double)a * (double) min;
            this.index = index;
        }

        @Override
        public int compareTo(Minion o) {
            if (this.ratio > o.ratio) return 1;
            if (this.ratio < o.ratio) return -1;
            return 0;
        }
    }
    public static int[] answer(int[][] minions) {
        int n = minions.length;
        Minion[] m = new Minion[n];
        for (int i = 0; i < n; ++i) {
            m[i] = new Minion(minions[i][0],
                              minions[i][1],
                              minions[i][2],
                              i);
        }
        Arrays.sort(m);
        int[] ret = new int[n];
        for (int i = 0; i < n; ++i)
            ret[i] = m[i].index;
        return ret;
        // Your code goes here.

    }

}
