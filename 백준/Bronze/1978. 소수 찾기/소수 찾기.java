import java.util.*;

public class Main {
    public static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
            primeCheck(list.get(i));
        }

        System.out.println(count);
    }
    public static void primeCheck(int number){
        if (number < 2) {
            return;
        }

        if (number == 2) {
            count++;
            return;
        }

        for (int i = 2; i < 1000; i++) {
            if (number != i && number % i == 0) {
                return;
            }
        }

        count++;
    }

}
