import java.util.*;

public class Main {

    static void tc(Scanner sc) {
        int n = sc.nextInt();
        int cnt = 0;

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            cnt += a[i];
        }

        if (cnt >= n - cnt) {
            System.out.println("Bessie");
        } else {
            System.out.println("Elsie");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            tc(sc);
        }

        sc.close();
    }
}
