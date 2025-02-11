import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int r = 31;
        long m = 1234567891L;

        long hash = 0;
        long pow = 1;

        for (int i = 0; i < n; i++) {
            int value = str.charAt(i) -'a' + 1;
            hash = (hash + (value * pow) % m) % m;
            pow = (pow * r) % m;
        }

        System.out.println(hash);
    }
}