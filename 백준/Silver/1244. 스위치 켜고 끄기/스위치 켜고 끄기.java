import java.io.*;
import java.util.*;

/*
1. 입력
스위치의 개수 n
각 스위치의 상태 0 또는 1
학생 수 m
...m줄 동안
성별, 받은 수


2. 출력
스위치의 상태, 한 줄에 20개씩

3. 풀이


*/
public class Main {
    static int n;
    static int [] button;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        button = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            button[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            if(gender == 1){
                for (int j = 1; j <= n; j++) {
                    if(j%count==0){
                        buttonChange(j);

                    }
                }
            } else{
                girl(count);
            }
        }
        print();
        bw.flush();
        bw.close();
    }
    
    static void girl(int start){
        buttonChange(start);
        int left = start-1;
        int right = start+1;
        while(left>0 && right<= n && button[left] == button[right]){
           buttonChange(left);
           buttonChange(right);
           left--;
           right++;
        }
    }
    
    static void buttonChange(int target){
        button[target] = button[target] == 1 ? 0 : 1;
    }
    
    static void print() throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            bw.write(button[i]+" ");
            if(i%20 == 0){
                bw.write("\n");
            }
        }
        if(n%20!=0){
            bw.write("\n");
        }
    }
}