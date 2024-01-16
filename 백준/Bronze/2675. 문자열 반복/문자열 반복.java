import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int r;
    public static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                for (int k = 0; k <r ; k++) {
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println();
        }
    }
}