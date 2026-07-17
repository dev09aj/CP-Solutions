import java.io.*;
import java.util.*;

public class Main {

    static final int P = 110;
    static final int N = 1000000;
    static final int SZ_V = 1 << 18;

    static String type;

    static ArrayList<Integer> ps = new ArrayList<>();
    static ArrayList<Integer> pks = new ArrayList<>();
    static ArrayList<Integer> v = new ArrayList<>();
    static int[] idx = new int[N + 1];

    static FastScanner fs = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    static void init() {
        int[] maxP = new int[N + 1];
        maxP[1] = 1;

        for (int i = 2; i <= N; i++) {
            if (maxP[i] == 0) {
                ps.add(i);
                for (int j = i; j <= N; j += i) {
                    maxP[j] = i;
                }
            }
        }

        while (ps.size() > P) ps.remove(ps.size() - 1);

        for (int p : ps) {
            int x = p;
            while ((long) x * p <= N) x *= p;
            pks.add(x);
        }

        for (int i = 1; i <= N && v.size() < SZ_V; i++) {
            if (maxP[i] <= ps.get(ps.size() - 1)) {
                v.add(i);
            }
        }

        for (int i = 0; i < v.size(); i++) {
            idx[v.get(i)] = i;
        }
    }

    static void run1() {
        int n = fs.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }

        ArrayList<Integer> b = new ArrayList<>(pks);

        ArrayList<Integer> bits = new ArrayList<>();

        for (int x : a) {
            for (int j = 19; j >= 0; j--) {
                bits.add((x >> j) & 1);
            }
        }

        while (bits.size() % 18 != 0) bits.add(0);

        for (int i = 0; i < bits.size(); i += 18) {
            int now = 0;
            for (int j = 0; j < 18; j++) {
                now = now * 2 + bits.get(i + j);
            }
            b.add(v.get(now));
        }

        out.println(b.size());
        for (int x : b) out.print(x + " ");
        out.println();
        out.flush();
    }

    static int ask(int i, int j) {
        out.println("? " + (i + 1) + " " + (j + 1));
        out.flush();
        return fs.nextInt();
    }

    static void run2() {
        int n = fs.nextInt();
        int k = fs.nextInt();

        ArrayList<Integer> bits = new ArrayList<>();

        for (int i = P; i < k; i++) {
            int x = 1;
            for (int j = 0; j < P; j++) {
                int g = ask(i, j);
                x *= g;
            }

            int now = idx[x];

            for (int j = 17; j >= 0; j--) {
                bits.add((now >> j) & 1);
            }
        }

        int[] a = new int[n];

        for (int i = 0, pos = 0; i < n; i++, pos += 20) {
            int now = 0;
            for (int j = 0; j < 20; j++) {
                now = now * 2 + bits.get(pos + j);
            }
            a[i] = now;
        }

        out.print("!");
        for (int x : a) out.print(" " + x);
        out.println();
        out.flush();
    }

    public static void main(String[] args) {
        init();

        type = fs.next();
        int T = fs.nextInt();

        while (T-- > 0) {
            if (type.equals("first")) {
                run1();
            } else {
                run2();
            }
        }

        out.flush();
    }

    // Fast Scanner
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
                    if (len <= 0) return -1;
                } catch (IOException e) {
                    return -1;
                }
            }
            return buffer[ptr++];
        }

        String next() {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1 && c <= ' ');
            while (c != -1 && c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }

        int nextInt() {
            int c;
            while ((c = read()) <= ' ') ;
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
