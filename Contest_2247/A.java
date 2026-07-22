import java.util.Scanner;

public class Main {

    public static void solve(Scanner sc) {
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            sum += x;
        }

        if (Math.abs(sum) % 4 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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
