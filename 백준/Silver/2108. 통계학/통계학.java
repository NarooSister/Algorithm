import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1. 입력
수의 개수 N
N개의 줄 동안 정수

2. 출력
산술평균
중앙값
최빈값
범위

3. 풀이
각각의 경우를 출력해준다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 산술 평균
        double average = 0;
        for (int a : arr) {
            average += a;
        }
        System.out.println(Math.round(average / n));

        // 중앙값
        Arrays.sort(arr);
        System.out.println(arr[n / 2]);

        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> maxKeys = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            
            if (max < value) {  
                maxKeys.clear();
                maxKeys.add(key);
                max = value;
            } else if(max == value){
                maxKeys.add(key);
            }
        }
        Collections.sort(maxKeys);
        if (maxKeys.size() > 1) {
            System.out.println(maxKeys.get(1));
        } else {
            System.out.println(maxKeys.get(0));
        }

        // 범위
        System.out.println(arr[n - 1] - arr[0]);
    }
}