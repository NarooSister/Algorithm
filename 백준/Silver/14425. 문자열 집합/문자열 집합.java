import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String [] S = new String[N];
        for (int i = 0; i <N ; i++) {
            S [i]= br.readLine();
        }
        String [] test = new String[M];
        for (int i = 0; i <M ; i++) {
            test[i] = br.readLine();
        }
        int count=0;
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                if(S[i].equals(test[j])){
                    count++;
                }
            }
        }System.out.println(count);
    }
}