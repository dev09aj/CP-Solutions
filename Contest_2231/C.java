import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Map<Integer, Long> cnt1 = new HashMap<>();
            Map<Integer, Long> cnt2 = new HashMap<>();

            int x = a[0];

            Set<Integer> s = new HashSet<>();
            int c = 0;

            while (!s.contains(x)) {
                cnt1.putIfAbsent(x, 0L);
                cnt2.putIfAbsent(x, 0L);

                cnt1.put(x, cnt1.get(x) + 1);
                cnt2.put(x, cnt2.get(x) + c);

                s.add(x);

                if ((x & 1) == 1) {
                    x++;
                } else {
                    x >>= 1;
                }

                c++;
            }

            for (int i = 1; i < n; i++) {
                x = a[i];

                s = new HashSet<>();
                c = 0;

                while (!s.contains(x)) {
                    if (cnt1.containsKey(x)) {
                        cnt1.put(x, cnt1.get(x) + 1);
                        cnt2.put(x, cnt2.get(x) + c);
                    }

                    s.add(x);

                    if ((x & 1) == 1) {
                        x++;
                    } else {
                        x >>= 1;
                    }

                    c++;
                }
            }

            long ans = (long) 1e18;

            for (int k : cnt1.keySet()) {
                long v = cnt1.get(k);

                if (v == n) {
                    ans = Math.min(ans, cnt2.get(k));
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
