import java.io.*;
import java.util.*;
/*
1. 입력
T (-1,000,000,000<= T <= 1,000,000,000)
[n
n개의 정수 배열]
...

2. 출력
부배열의 합이 T가 되는 모든 쌍의 개수
없을 경우 0

3. 문제 접근법
- a의 모든 부배열의 합을 HashMap에 저장하여 빈도 기록
- b의 모든 부배열의 합을 계산하고 a의 합과 합쳐서 T 쌍 찾기
-> T-a = b인 b의 원소를 찾기 위해 이분탐색으로 탐색한다.

 */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long t = Long.parseLong(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int [] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int [] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> aSum = sum(n, A);
        List<Long> bSum = sum(m, B);
        Collections.sort(bSum);

        long count = 0;
        for (long a : aSum){
            long target = t - a;
            count += highBinarySearch(bSum, target) - lowBinarySearch(bSum, target);
        }
        System.out.println(count);
    }
    // 타켓과 같거나 큰 값의 첫 위치
    static int lowBinarySearch(List<Long> list, long target){
        int left = 0;
        int right = list.size();

        while (left<right){
            int mid = (left+right)/2;
            if(list.get(mid) >= target){
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }
    // 타겟보다 큰 값의 첫 위치
    static int highBinarySearch(List<Long> list, long target){
        int left = 0;
        int right = list.size();

        while (left<right){
            int mid = (left+right)/2;
            if(list.get(mid) > target){
                right = mid;
            } else {
                left = mid +1;
            }
        }
        return left;
    }

    static List<Long> sum(int m, int[] b) {
        List<Long> sums = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j <m ; j++) {
                sum += b[j];
                sums.add(sum);
            }
        }
        return sums;
    }
}
