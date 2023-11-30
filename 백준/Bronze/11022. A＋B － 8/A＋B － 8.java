import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> AryT = new ArrayList<>();
        int T = Integer. parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write("Case #"+(i+1)+": "+A+" + "+B+" = "+(A+B)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}