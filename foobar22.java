/**
 * Created by Jack.Yang on 10/22/2015.
 */
public class foobar22 {
    public static String[] answer(int x) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int digit = x % 3;
            if (digit == 0) sb.append('-');
            else if (digit == 1) sb.append('R');
            else if (digit == 2) {
                sb.append('L');
                ++x;
            }
            x /= 3;
        }
        char[] ans = sb.toString().toCharArray();
        String[] ret = new String[ans.length];
        for (int i = 0; i < ans.length; ++i) {
            ret[i] = "" + ans[i];
        }
        return ret;
        // Your code goes before here.

    }
    public static void main(String[] args) {
        String[] aaa = answer(8);
        for (String s : aaa) {
            System.out.print(s);
        }
    }
}
