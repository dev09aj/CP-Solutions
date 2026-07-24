import java.util.*;

public class Main {

    static ArrayList<Integer>[] g;
    static int[] leaf;
    static boolean ok;

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.first != other.first)
                return this.first - other.first;
            return this.second - other.second;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair))
                return false;
            Pair p = (Pair) obj;
            return this.first == p.first && this.second == p.second;
        }
    }

    static Pair dfs(int u, int p) {
        if (!ok)
            return new Pair(0, 0);

        if (leaf[u] != 0) {
            for (int v : g[u]) {
                if (v != p) {
                    ok = false;
                    return new Pair(0, 0);
                }
            }
            return new Pair(leaf[u], leaf[u]);
        }

        ArrayList<Pair> segs = new ArrayList<>();

        for (int v : g[u]) {
            if (v != p) {
                Pair cur = dfs(v, u);
                segs.add(cur);
                if (!ok)
                    return new Pair(0, 0);
            }
        }

        if (segs.isEmpty()) {
            ok = false;
            return new Pair(0, 0);
        }

        ArrayList<Pair> sortedSegs = new ArrayList<>(segs);
        Collections.sort(sortedSegs);

        for (int i = 0; i < sortedSegs.size() - 1; i++) {
            if (sortedSegs.get(i).second + 1 != sortedSegs.get(i + 1).first) {
                ok = false;
                return new Pair(0, 0);
            }
        }

        int startPos = -1;
        for (int i = 0; i < segs.size(); i++) {
            if (segs.get(i).equals(sortedSegs.get(0))) {
                startPos = i;
                break;
            }
        }

        if (startPos == -1) {
            ok = false;
            return new Pair(0, 0);
        }

        for (int i = 0; i < segs.size(); i++) {
            if (!segs.get((startPos + i) % segs.size()).equals(sortedSegs.get(i))) {
                ok = false;
                return new Pair(0, 0);
            }
        }

        return new Pair(sortedSegs.get(0).first,
                sortedSegs.get(sortedSegs.size() - 1).second);
    }

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            g[i] = new ArrayList<>();

        leaf = new int[n + 1];
        ok = true;

        for (int i = 2; i <= n; i++) {
            int p = sc.nextInt();
            g[p].add(i);
            g[i].add(p);
        }

        int k = 0;
        for (int i = 1; i <= n; i++) {
            leaf[i] = sc.nextInt();
            k = Math.max(k, leaf[i]);
        }

        if (n == 1) {
            System.out.println("YES");
            return;
        }

        Pair res = dfs(1, -1);

        if (ok && res.first == 1 && res.second == k)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();
        while (tc-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
