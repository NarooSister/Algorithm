import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        sb.append("<");
        int idx = 0;
        while (!list.isEmpty()) {
            idx = (idx + k - 1) % list.size();

            if (list.size() == 1) {
                sb.append(list.get(idx)).append(">");
            } else {
                sb.append(list.get(idx)).append(", ");
            }
            list.remove(idx);
        }

        System.out.println(sb);
    }
}


