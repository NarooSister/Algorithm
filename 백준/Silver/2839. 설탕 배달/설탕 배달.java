import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = Integer.MAX_VALUE;

        for (int i = 0; i <= n/5; i++) {
            int current = n -(i*5);
            if(current %3 == 0){
                count = Math.min(count, i + (current/3));
            }
        }
        System.out.println(count == Integer.MAX_VALUE ? -1 : count);
    }
}