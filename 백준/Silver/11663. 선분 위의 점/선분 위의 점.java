import java.io.*;
import java.util.*;


/*
1. 입력
점의 개수 n, 선분의 개수 m
점의 좌표 n개
...m줄 동안
선분의 시작점, 끝점

2. 출력
각각의 선분마다 위에 주어진 점이 몇개 있는지

3. 문제 접근법
점들을 정렬한다.
이진탐색을 두번 사용하여 시작점 이상인 점, 끝점 이하인 점을 찾는다.
선분 내에 포함된 점의 개수 계산

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] dot = new int[n];
        for (int i = 0; i < n ; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(result(dot, start, end)+"\n");
        }
        bw.flush();
        bw.close();
    }
    // 선분 위에 있는 점의 개수 계산
    static int result(int [] dot, int start, int end){
        int left = lowBinarySearch(dot, start); //왼쪽 점 인덱스
        int right = highBinarySearch(dot, end); // 오른쪽 점 인덱스
        if(left > right) return 0;
        return right-left+1;
    }
    //선분의 시작점보다 큰 첫번째 점의 위치
    static int lowBinarySearch(int[] dot, int start){
        int left = 0;
        int right = dot.length;
        while(left<right) {
            int mid = (left + right) / 2;
            if(dot[mid] < start)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    //선분의 끝점보다 작은 마지막 점
    static int highBinarySearch(int[] dot, int end){
        int left = 0;
        int right = dot.length;
        while(left<right) {
            int mid = (left + right) / 2;
            if(dot[mid] <= end) // 끝 점 포함
                left = mid + 1;
            else
                right = mid;
        }
        return left-1;
    }
}

