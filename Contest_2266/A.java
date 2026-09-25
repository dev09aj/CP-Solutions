import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        int N = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int m = Math.min(a, Math.min(b, c));

        System.out.println(N - m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
