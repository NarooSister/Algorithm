import java.io.*;


/*
1. 입력
테스트 케이스 t


2. 출력
각 테스트 케이스마다 파도반 수열 P(N) 구하기

3. 풀이
dp를 사용해서 이전 수를 저장하면서 수열을 구한다.

*/
public class Main {
    static long [] save = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(padovan(n)+"\n");
        }
        bw.flush();
        bw.close();
    }
    static long padovan(int n){
        save[1] = 1;
        save[2] = 1;
        save[3] = 1;
        for (int i = 4; i <= n; i++) {
            save[i] =  save[i-2]+save[i-3];
        }
        return save[n];
    }
}