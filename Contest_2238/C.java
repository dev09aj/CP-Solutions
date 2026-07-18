import java.io.*;
import java.util.*;

public class Main {
    static final int MAXN = 200000;

    static ArrayList<Integer>[] g = new ArrayList[MAXN];
    static int[] depth = new int[MAXN];
    static int[] dp = new int[MAXN];
    static long[] ans = new long[MAXN];

    static {
        for (int i = 0; i < MAXN; i++) {
            g[i] = new ArrayList<>();
        }
    }

    static void dfs(int v, int p) {
        ans[v] = 0;
        dp[v] = depth[v];

        int m1 = depth[v];
        int m2 = depth[v];

        for (int u : g[v]) {
            if (u != p) {
                depth[u] = depth[v] + 1;
                dfs(u, v);

                dp[v] = Math.max(dp[v], dp[u]);
                ans[v] += ans[u];

                if (dp[u] >= m1) {
                    m2 = m1;
                    m1 = dp[u];
                } else if (dp[u] >= m2) {
                    m2 = dp[u];
                }
            }
        }

        ans[v] += (long) (m2 - depth[v] + 1);
    }

    static void solve(FastScanner fs, PrintWriter out) throws IOException {
        int n = fs.nextInt();

        for (int i = 1; i < n; i++) {
            int p = fs.nextInt();
            g[p - 1].add(i);
        }

        depth[0] = 0;
        dfs(0, -1);

        out.println(ans[0]);

        for (int i = 0; i < n; i++) {
            g[i].clear();
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs, out);
        }

        out.flush();
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1)
                    return -1;
            }

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }
    }
}
