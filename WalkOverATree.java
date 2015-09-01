/**
 * Created by Jack.Yang on 9/1/2015.
 */
import java.util.*;
// SRM666 div 1 easy
public class WalkOverATree {
    public int maxNodesVisited(int[] parent, int L) {
        int N = parent.length + 1;

        int[] dist = new int[N];
        int max = 0;
        for (int i = 1; i < N; i++) {
            dist[i] = dist[parent[i - 1]] + 1;
            max = Math.max(max, dist[i]);
        }

        if (L <= max) {
            return L + 1;
        }

        return Math.min(N, (L - max) / 2 + max + 1);
    }
}
