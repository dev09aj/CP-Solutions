import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int C = sc.nextInt();

            int ans = 0;

            int[] a = new int[n];
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }

            boolean needReorder = false;

            for (int i = 0; i < n; i++) {
                if (a[i] < b[i]) {
                    needReorder = true;
                }

                ans += a[i];
                ans -= b[i];
            }

            if (needReorder) {
                needReorder = false;
                ans += C;

                Arrays.sort(a);
                Arrays.sort(b);

                for (int i = 0; i < n; i++) {
                    if (a[i] < b[i]) {
                        needReorder = true;
                    }
                }
            }

            if (needReorder) {
                System.out.println(-1);
            } else {
                System.out.println(ans);
            }
        }

        sc.close();
    }
}
