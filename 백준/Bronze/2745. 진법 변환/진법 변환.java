import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b = sc.next();
        long n = sc.nextLong();

        long result = 0;
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            int value;

            if (Character.isDigit(c)) {
                value = c - '0'; // 숫자일 경우
            } else {
                value = c - 'A' + 10; // 알파벳일 경우
            }

            result += value * Math.pow(n, b.length() - i - 1);
        }
        System.out.println(result);
    }
}
