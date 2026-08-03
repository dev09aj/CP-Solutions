import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        long ans = 0;

        for (int b = 1; b <= n; b++) {
            long x = n / b;
            ans += x * x;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
