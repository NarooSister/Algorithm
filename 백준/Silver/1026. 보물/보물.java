import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            B.add(sc.nextInt());
        }

        // A의 최솟값 * B의 최댓값이 곱해지도록 정렬한다.
        // A는 작은 수부터, B는 큰 수부터 정렬한 뒤 곱해준다.
        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A.get(i)*B.get(i);
        }
        System.out.println(result);
    }
}

