import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = "bigchadjeff";
        int tt = sc.nextInt();

        while (tt-- > 0) {
            int i = sc.nextInt();
            System.out.println(s.charAt(i - 1));
        }

        sc.close();
    }
}
