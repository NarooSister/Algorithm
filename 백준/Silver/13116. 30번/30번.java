import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(findLCA(a,b)*10+"\n");
        }
        bw.flush();
        bw.close();
    }
    static int findLCA(int a, int b){
        while(a!=b){    // 두 노드가 같아질 때까지
            if(a>b){    // a>b이면 a의 부모로 이동
                a /= 2;
            } else{
                b /= 2; // b>a이면 b의 부모로 이동
            }
        }
        return a;
    }
}
