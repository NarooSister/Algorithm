import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
1. 입력
상자의 개수 n
각 상자의 크기

2. 출력
한줄에 넣을 수 있는 최대 상자 개수

3. 풀이
LIS(최장 증가 부분 수열) 문제
dp에 저장해서 수열을 구한다.

*/
public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        arr = new int[n];
        int lis = 0;
        for (int i = 0; i < n; i++) {
            if(lis == 0 || arr[lis-1] < boxes[i]){
                arr[lis] = boxes[i];
                lis++;
            } else{
                int idx = binarySearch(0,lis,boxes[i]);
                arr[idx] = boxes[i];
            }
        }
        System.out.println(lis);
    }

    static int binarySearch(int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {  // 중간값보다 현재값이 크면
                left = mid + 1;
            } else { // 작을 경우 왼쪽으로 가서 찾기
                right = mid;
            }
        }
        return right;
    }

}