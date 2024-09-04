import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [][] matA = new int[5][5];
        int [][] matB = new int[5][5];
        String [] names = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

        // 행렬 A : 일의 난이드
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                matA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 행렬 B : 일의 처리 시간
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                matB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각각의 최종일량
        int [] totalWork = new int [5];

        // 예상일량 구하기
        int minWork = Integer.MAX_VALUE, minWorker = 0;
        for (int x = 0; x < 5; x++) {
            int work = 0;  //각각의 일의 양
            for (int y = 0; y < 5; y++) {
                for (int i = 0; i < 5; i++) {
                   work += matA[x][i] * matB[i][y];
                }
                totalWork[x] = work;    //최종 일량
            }
            // 최종 일량이 가장 작은 사람 찾기
            if(totalWork[x] <= minWork){
                minWork = totalWork[x];
                minWorker = x;
            }
        }
        System.out.println(names[minWorker]);
    }
}
