import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        
        int answer = 0;
        for (int A = 0; A < n+1; A++) {
            for (int B = 0; B < n+1 ; B++) {
                for (int C = 0; C < n+1 ; C++) {
                    if(A+B+C == n){
                        if(A>=B+2){
                            if(A!=0 && B!=0 && C!=0){
                                if(C % 2 == 0){
                                    answer += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
