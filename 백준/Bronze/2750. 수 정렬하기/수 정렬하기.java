import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arrN);

        for (int i = 0; i < n; i++) {
            System.out.println(arrN[i]);
        }
    }
}