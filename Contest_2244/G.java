import java.io.*;
import java.util.*;

public class Main {

    static class Fenwick {
        int n;
        long[] tree;

        Fenwick(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        int lowbit(int x) {
            return x & (-x);
        }

        void update(int pos, long val) {
            while (pos <= n) {
                tree[pos] = Math.max(tree[pos], val);
                pos += lowbit(pos);
            }
        }

        long query(int pos) {
            long ans = 0;
            while (pos > 0) {
                ans = Math.max(ans, tree[pos]);
                pos -= lowbit(pos);
            }
            return ans;
        }
    }

    static class Pair {
        int pos;
        long val;

        Pair(int pos, long val) {
            this.pos = pos;
            this.val = val;
        }
    }

    static void solve(FastScanner fs) {
        int n = fs.nextInt();
        long[] a = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = fs.nextLong();
        }

        Fenwick fenwick = new Fenwick(n);

        ArrayList<Pair>[] events = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            events[i] = new ArrayList<>();
        }

        long ans = 0;

        for (int i = 1; i <= n; i++) {

            for (Pair p : events[i]) {
                fenwick.update(p.pos, p.val);
            }

            int limit = (int) (i - a[i] - 1);
            long mx = 0;

            if (limit > 0) {
                mx = fenwick.query(Math.min(n, limit));
            }

            long dp = a[i] + mx;
            ans = Math.max(ans, dp);

            long activate = i + a[i] + 1;
            if (activate <= n) {
                events[(int) activate].add(new Pair(i, dp));
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
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

        private int read() {
            if (ptr >= len) {
                try {
                    len = in.read(buffer);
                    ptr = 0;
                } catch (IOException e) {
                    return -1;
                }
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() {
            int c;
            while ((c = read()) <= ' ') ;
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }

        int nextInt() {
            return (int) nextLong();
        }
    }
}
