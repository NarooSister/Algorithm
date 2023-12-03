import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] ary = new String[T];
        for (int i = 0; i <T ; i++) {
            ary[i] = sc.next();
        }
        for (int i = 0; i <T ; i++) {
            System.out.println((ary[i].charAt(0))+ary[i].substring(ary[i].length()-1));
        }
    }
}
