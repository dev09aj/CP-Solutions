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

            int ans = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] > 1) {
                    ans += a[i];
                }
            }

            if (a[n - 1] == 1) {
                ans++;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
