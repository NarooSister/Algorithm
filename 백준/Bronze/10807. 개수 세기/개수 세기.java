import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> n = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int result = 0;

        for (int i = 0; i < number; i++){
            int secondLine = sc.nextInt();
            n.add(secondLine);
        }
        int v = sc.nextInt();
        for (int i = 0; i < number; i++) {
            if (n.get(i).equals(v)){
                result += 1;
            }
        }
        System.out.println(result);
    }
}