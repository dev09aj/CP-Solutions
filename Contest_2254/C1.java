import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();

            int[] cnta = new int[2];
            int[] cntb = new int[2];

            for (int i = 0; i < n; i++) {
                if (a.charAt(i) == '1') {
                    cnta[i % 2]++;
                }

                if (b.charAt(i) == '1') {
                    cntb[i % 2]++;
                }
            }

            if (cnta[0] == cntb[0] && cnta[1] == cntb[1]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
