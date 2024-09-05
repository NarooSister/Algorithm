import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, n); // 배열의 한 변 크기
        int answer = funcZ(r, c, size, 0);
        System.out.println(answer);
    }

    // answer를 함수 인자로 받아서 상태를 유지
    public static int funcZ(int r, int c, int size, int answer) {
        // 배열의 한 변의 크기가 1이 되면 r, c를 찾은 것이므로 반환
        if (size == 1) {
            return answer;
        }

        int half = size / 2;
        // 1사분면에 있는 경우
        if (r < half && c < half) {
            return funcZ(r, c, half, answer);
        }
        // 2사분면에 있는 경우
        else if (r < half && c >= half) {
            return funcZ(r, c - half, half, answer + half * half);
        }
        // 3사분면에 있는 경우
        else if (r >= half && c < half) {
            return funcZ(r - half, c, half, answer + half * half * 2);
        }
        // 4사분면에 있는 경우
        else {
            return funcZ(r - half, c - half, half, answer + half * half * 3);
        }
    }
}
