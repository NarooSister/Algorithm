import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<String> strings;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            strings = new ArrayList<>();
            dfs(1, "1", N);
            Collections.sort(strings);
            for (String string : strings) {
                System.out.println(string);
            }
            System.out.println();
        }
    }

    private static void dfs(int num, String str, int N) {
        // 모든 숫자가 다 처리된 경우 수식 저장
        if (num == N) {
            if (func(str) == 0) {
                strings.add(str);
            }
            return;
        }
        // 다음 숫자와 +,-," " 넣기
        dfs(num + 1, str + "+" + (num + 1), N);
        dfs(num + 1, str + "-" + (num + 1), N);
        dfs(num + 1, str + " " + (num + 1), N);
    }

    private static int func(String str) {
        String formatStr = str.replaceAll(" ", "");
        int currentNum = 0;
        int sum = 0;
        char sign = '+'; //첫번째 기호는 '+'로 가정

        for (int i = 0; i < formatStr.length(); i++) {
            char c = formatStr.charAt(i);

            //숫자를 만났을 때
            if(Character.isDigit(c)){
                //공백 때문에 붙어있는 경우는 십의자리로 변경
                currentNum = currentNum * 10 + (c - '0');
            }
            // 기호를 만났거나 마지막 숫자일 때
            if(!Character.isDigit(c)|| i ==formatStr.length() -1){
                if(sign == '+'){
                    sum += currentNum;
                } else if (sign == '-') {
                    sum -= currentNum;
                }
                sign = c;   //기호 업데이트
                currentNum = 0;
            }
        }
            return sum;
    }

}