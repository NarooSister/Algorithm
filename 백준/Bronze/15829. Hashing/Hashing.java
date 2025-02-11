import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();
        int hash = 0;
        for (int i = 0; i < n; i++) {
            hash += (chars[i] - 96) * Math.pow(31, i);
        }
        System.out.println(hash);
    }
}