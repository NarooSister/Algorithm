import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Character> deque = new ArrayDeque<>();
        Deque<Boolean> isFront = new ArrayDeque<>();    // 추가된 위치 앞/뒤를 추적


        for (int i = 0; i < n; i++) {
            // 첫번째는 무조건 숫자, 두번째는 문자이므로
            // String [] 에 담아 숫자만 꺼내거나 문자만 꺼낸다.
            String[] str = br.readLine().split(" ");
            int num = Integer.parseInt(str[0]);

            switch (num) {
                case 1:
                    // 맨 뒤에 추가
                    char c = str[1].charAt(0);
                    deque.offerLast(c);
                    isFront.offerLast(false);
                    break;
                case 2:
                    // 맨 앞에 추가
                    c = str[1].charAt(0);
                    deque.offerFirst(c);
                    isFront.offerLast(true);
                    break;
                case 3:
                    if (!deque.isEmpty()) {
                        // 마지막에 넣은 곳이 앞인지 뒤인지에 따라 꺼내준다.
                        if (isFront.pollLast()) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    }
                    break;
            }
        }

        if(deque.isEmpty()){
            System.out.println("0");
        } else {
            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()){
                sb.append(deque.pollFirst());
            }
            System.out.println(sb);
        }
    }
}
