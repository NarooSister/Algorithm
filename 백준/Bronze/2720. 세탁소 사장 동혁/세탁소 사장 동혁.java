import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <T ; i++) {
            int result = Integer.parseInt(br.readLine());
            sb.append(result/quarter+" ");
            result %= quarter;
            sb.append(result/dime + " ");
            result %= dime;
            sb.append(result/nickel + " ");
            result %= nickel;
            sb.append(result/penny + "\n");
        }
        System.out.println(sb);
    }
}
