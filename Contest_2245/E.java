import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static long ans;
    static int c;

    static void dfs(int u) {
        vis[u] = true;
        for (int v : g[u]) {
            if ((g[v].size() & 1) == 1) {
                ans += c++;
            } else if (!vis[v]) {
                dfs(v);
            }
        }
    }

    static void solve(FastScanner fs) throws IOException {
        int n = fs.nextInt();

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }

        vis = new boolean[n];
        ans = 0;

        for (int u = 0; u < n; u++) {
            if ((g[u].size() & 1) == 0 && !vis[u]) {
                c = 0;
                dfs(u);
            }
        }

        for (int u = 0; u < n; u++) {
            for (int v : g[u]) {
                if (v > u) {
                    ans += (g[u].size() & g[v].size() & 1);
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int t = fs.nextInt();
        while (t-- > 0) {
            solve(fs);
        }
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
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
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
