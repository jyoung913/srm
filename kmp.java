/**
 * Created by Jack.Yang on 8/21/2015.
 */
public class kmp {

    public static int find(String s, String w) {
        int[] table = getFailureTable(w);
        int i = 0, m = 0;
        int len = s.length();
        while (i + m < len) {
            if (s.charAt(i + m) == w.charAt(m)) {
                if (m == w.length() - 1) return i;
                ++m; continue;
            }
            //else
            if (m > 0) {
                i += w.length() - table[m - 1];
                m = table[m - 1];
            } else {
                ++i;
            }
        }
        return -1;
    }

    // short w edge case can fuck itself
    static int[] getFailureTable(String w) {
        int n = w.length();
        int[] result = new int[n];
        for (int i = 1; i < n; ++i) {
            int pos = result[i - 1];
            while (w.charAt(i) != w.charAt(pos) && pos > 0) {
                pos = result[pos - 1];
            }
            if (w.charAt(i) == w.charAt(pos)) {
                result[i] = pos + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.print(find("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
    }
}
