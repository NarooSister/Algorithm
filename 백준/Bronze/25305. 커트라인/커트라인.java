import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] arrX = new int[N];
        for (int i = 0; i <N ; i++) {
            arrX[i] = sc.nextInt();
        }
        Arrays.sort(arrX);
        System.out.println(arrX[N-K]);
    }
}