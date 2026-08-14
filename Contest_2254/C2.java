import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();

            long ans = 0;
            boolean ok = true;

            for (int k = 0; k < 2; k++) {
                ArrayList<Integer> p1 = new ArrayList<>();
                ArrayList<Integer> p2 = new ArrayList<>();

                for (int i = k; i < n; i += 2) {
                    if (a.charAt(i) == '1')
                        p1.add(i);

                    if (b.charAt(i) == '1')
                        p2.add(i);
                }

                if (p1.size() != p2.size()) {
                    ok = false;
                    break;
                }

                for (int i = 0; i < p1.size(); i++) {
                    ans += Math.abs(p1.get(i) - p2.get(i));
                }
            }

            if (!ok)
                System.out.println(-1);
            else
                System.out.println(ans / 2);
        }

        sc.close();
    }
}
