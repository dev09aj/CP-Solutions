import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();

            long[] v = new long[n + 1];
            long[] cnt = new long[n + 1];

            for (int i = 1; i <= n; i++) {
                v[i] = fs.nextLong();
                cnt[(int) v[i]]++;
            }

            long[] have = new long[n + 1];

            have[n] = cnt[n];

            for (int i = n - 1; i >= 1; i--) {
                have[i] = have[i + 1] + cnt[i];
            }

            long init = 0;
            long aft = 0;

            for (int i = 1; i <= n; i++) {
                init += i * v[i];

                aft += have[i] * (2L * n - have[i] + 1) / 2;
            }

            long cur = aft - init;
            long mx = 0;

            for (int i = 1; i <= n; i++) {
                mx = Math.max(mx, i - n + have[(int) v[i]] - 1);
            }

            out.append(cur + mx).append('\n');
        }

        System.out.print(out);
    }

    // Fast input
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }

            long res = 0;
            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return neg ? -res : res;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
