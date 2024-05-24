import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = (int) s.charAt(i) - 65;
            if (num == 18 || num == 21 || num == 24) {
                num = (int) s.charAt(i) - 66;
            } else if (num == 25) {
                num = (int) s.charAt(i) - 67;
            }
            sum += (num / 3) + 2;
        }
        System.out.println(sum+s.length());
    }
}
