import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

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

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt() - 1;
            }

            for (int i = 0; i < n; i++) {
                b[i] = fs.nextInt() - 1;
            }

            int[] pa = new int[n + 1];
            int[] pb = new int[n + 1];
            int[] dp = new int[n + 1];

            Arrays.fill(pa, n);
            Arrays.fill(pb, n);
            Arrays.fill(dp, n);

            long ans = 0;

            for (int i = n - 1; i >= 0; i--) {
                pa[a[i]] = i;
                pb[b[i]] = i;

                if (a[i] == b[i]) {
                    int x = a[i] + 1;
                    if (pa[x] == pb[x]) {
                        dp[i] = dp[pa[x]];
                    } else {
                        dp[i] = Math.min(pa[x], pb[x]);
                    }
                }

                if (pa[0] != pb[0]) {
                    ans += Math.min(pa[0], pb[0]) - i;
                } else {
                    ans += dp[pa[0]] - i;
                }
            }

            System.out.println(ans);
        }
    }
}
