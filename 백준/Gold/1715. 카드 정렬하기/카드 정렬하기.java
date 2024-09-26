

/*
1. 입력
정수의 개수 N
... N줄 동안
숫자 묶음 각각의 크기

2. 출력
최소 비교 횟수

3. 문제 접근법
우선순위 큐

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++) {
        queue.offer(Integer.parseInt(br.readLine()));
        }

        while(queue.size() > 1){
            int first = queue.poll();
            int second = queue.poll();
            int sum = first + second;
            result += sum;
            queue.offer(sum);
        }
        System.out.println(result);
    }
}
