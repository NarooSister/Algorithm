import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Long, Long> dp = new HashMap<>();
    static long p, q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        p = sc.nextLong();
        q = sc.nextLong();

        dp.put(0L, 1L);
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        if (dp.containsKey(n)) return dp.get(n);
        long result = solution(n / p) + solution(n / q);
        dp.put(n, result);
        return result;
    }

}