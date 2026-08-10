import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        long totalSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        int maxF = 0;
        int majVal = 0;

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            totalSum += x;
            freq.put(x, freq.getOrDefault(x, 0) + 1);

            if (freq.get(x) > maxF) {
                maxF = freq.get(x);
                majVal = x;
            }
        }

        int others = n - maxF;

        int maxMajorityPlayed = Math.min(maxF, others + 2);

        long ans = (totalSum - (long) maxF * majVal)
                 + (long) maxMajorityPlayed * majVal;

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
