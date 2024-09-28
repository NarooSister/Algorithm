import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력
배열의 크기 N
N의 각 원소
교환 가능한 최대 횟수 S

2. 출력
소트한 배열의 사전순으로 가장 늦은 것을 출력

3. 문제 접근법
가능한 교환횟수 내에서 최댓값을 만드려면
첫 위치부터 s번 이내까지 숫자 중 최댓값을 앞으로 가져와야한다.
남은 교환 횟수가 있다면 두번째 위치에서도 남은 교환횟수만큼 최댓값을 찾아 가져온다.

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());

        int currentIndex = 0;
        while(currentIndex < n-1 && s > 0){
            int max = currentIndex;
            // 현재 위치에서 교환 가능한 범위 내에서 최댓값 찾기
            // 현재위치 + 1 부터 s인 범위(n보다는 작은)까지 돌린다.
            for (int i = currentIndex + 1; i < n && i <= currentIndex + s; i++) {
                if(a[i] > a[max]){
                  max = i;
                }
            }
            // 최댓값과 최댓값보다 이전의 수, 두 수 교환
            while(max > currentIndex) {
                int tmp = a[max];
                a[max] = a[max -1];
                a[max -1] = tmp;
                max--;
                s--;
            }
            currentIndex++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

