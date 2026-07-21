import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    static class Pair {
        int u, v;

        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class Node implements Comparable<Node> {
        int cnt, id;

        Node(int cnt, int id) {
            this.cnt = cnt;
            this.id = id;
        }

        @Override
        public int compareTo(Node o) {
            if (cnt != o.cnt)
                return Integer.compare(cnt, o.cnt);
            return Integer.compare(id, o.id);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node))
                return false;
            Node other = (Node) obj;
            return cnt == other.cnt && id == other.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cnt, id);
        }
    }

    static void solve(FastScanner fs) throws Exception {
        long n = fs.nextLong();
        long k = fs.nextLong();

        long top = 0;
        for (int x = 1; x <= n / 2; x++) {
            top += x;
            if (2L * x <= n - 1)
                top += x;
        }
        top *= 2;

        if (k % 2 == 1 || k < 2 * (n - 1) || k > top) {
            System.out.println(-1);
            return;
        }

        if (n == 2) {
            System.out.println("1 2");
            return;
        }

        ArrayList<Integer> cnt = new ArrayList<>();
        cnt.add((int) ((n - 1) / 2));
        cnt.add((int) ((n - 1) / 2));
        if (n % 2 == 0)
            cnt.set(1, cnt.get(1) + 1);

        long cur = top / 2;
        k /= 2;

        for (int i = 0;; i++) {
            int id = i % 2;

            if (cnt.get(id) > 1 && cur - (cnt.get(id) - 1) >= k) {
                cur -= (cnt.get(id) - 1);
                cnt.add(1);
                cnt.set(id, cnt.get(id) - 1);
            } else if (cnt.get(id) > 1 || cur == k) {

                ArrayList<Pair> edges = new ArrayList<>();
                int cr = 2;
                int[] startv = new int[cnt.size()];

                for (int j = 0; j < cnt.size(); j++) {
                    startv[j] = cr;

                    if (j != id) {
                        int prv = 1;
                        for (int x = 0; x < cnt.get(j); x++) {
                            edges.add(new Pair(prv, cr));
                            prv = cr;
                            cr++;
                        }
                    } else {
                        int prv = 1;
                        int start = cr;

                        for (int x = 0; x < cnt.get(j) - 1; x++) {
                            edges.add(new Pair(prv, cr));
                            prv = cr;
                            cr++;
                        }

                        int was = cnt.get(j);
                        int neww = (int) (was - (cur - k));

                        if (neww == 1)
                            edges.add(new Pair(1, cr++));
                        else
                            edges.add(new Pair(start + (neww - 2), cr++));
                    }
                }

                TreeSet<Node> set = new TreeSet<>();

                for (int j = 0; j < cnt.size(); j++)
                    set.add(new Node(cnt.get(j), j));

                int[] per = new int[(int) n + 1];
                per[1] = 1;

                int lst = -1;

                for (int x = 2; x <= n; x++) {

                    Node curNode = set.last();

                    if (curNode.id == lst) {
                        curNode = set.lower(curNode);
                    }

                    set.remove(curNode);

                    per[startv[curNode.id]] = x;
                    startv[curNode.id]++;

                    lst = curNode.id;

                    cnt.set(curNode.id, cnt.get(curNode.id) - 1);

                    set.add(new Node(cnt.get(curNode.id), curNode.id));
                }

                StringBuilder sb = new StringBuilder();

                for (Pair e : edges) {
                    sb.append(per[e.u]).append(" ").append(per[e.v]).append("\n");
                }

                System.out.print(sb);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int t = fs.nextInt();

        while (t-- > 0) {
            solve(fs);
        }
    }
}
