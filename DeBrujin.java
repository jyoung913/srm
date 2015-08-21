import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Jack.Yang on 8/21/2015.
 */
public class DeBrujin {

    private static String getBinaryDeBrujin(int len) {
        if (len < 2) return null;
        int bound = 1 << (len - 1);
        int mask = bound - 1; // 111111
        // len - 1 digit: vertex,  1 digit: directed graph edge
        boolean[][] graph = new boolean[bound][2]; // visited: true, unvisited: false
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        Stack<Integer> stack = new Stack<>();

        while (!(graph[curr][0] && graph[curr][1] && stack.isEmpty())) {
            if (graph[curr][0] && graph[curr][1]) {
                sb.append(curr & 1);
                curr = stack.pop();
            } else {
                stack.push(curr);
                if (!graph[curr][0]) {
                    graph[curr][0] = true;
                    curr = (curr << 1) & mask;
                } else {
                    graph[curr][1] = true;
                    curr = (curr << 1) & mask | 1;
                }
            }
        }

        return sb.toString();

    }
    static private HashSet<String> visited;

    private static String getDeBrujin(char[] alphabet, int len) {
        --len;
        int m = alphabet.length;
        visited = new HashSet<>();
        Stack<String> stack = new Stack<>(); // stack trace
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) { sb.append(alphabet[0]); }
        String curr = sb.toString();
        while (!(getNeibour(alphabet, curr) == '\0' && stack.isEmpty())) {
            char neibour = getNeibour(alphabet, curr);
            if (neibour != '\0') {
                visited.add(curr + neibour);
                stack.push(curr);
                curr = curr.substring(1) + neibour;
            } else {
                sb.append(curr.charAt(curr.length() - 1));
                curr = stack.pop();
            }
        }
        return sb.toString();
    }

    private static char getNeibour(char[] alphabet, String curr) {
        for (char ch: alphabet)
            if (!visited.contains(curr + ch))
                return ch;
        return '\0';
    }

    public static void main(String[] args) {
        System.out.println(getDeBrujin("abcd".toCharArray(), 2));
    }
}
