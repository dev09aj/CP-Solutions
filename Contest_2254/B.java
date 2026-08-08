import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int ans = 1, x = 0;

            for (int i = 1; i < n; i++) {

                if (s.charAt(i) != s.charAt(i - 1)) {
                    ans++;
                }

                if (i == n - 1) {
                    break;
                }

                if (s.charAt(i) != s.charAt(i - 1)
                        && s.charAt(i) != s.charAt(i + 1)) {

                    if (s.charAt(i + 1) == s.charAt(i - 1)) {
                        x = 2;
                    } else {
                        x = Math.max(x, 1);
                    }
                }
            }

            System.out.println(ans - x);
        }

        sc.close();
    }
}
