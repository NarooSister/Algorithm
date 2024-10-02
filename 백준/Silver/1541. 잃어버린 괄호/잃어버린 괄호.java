import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 입력
식이 주어진다.

2. 출력
괄호를 쳐서 최소로 만든 이 식의 값

3. 풀이
+의 경우에는 괄호를 쳐도 변화가 없다.
가장 최솟값을 구하기 위해서는 -() 괄호 안의 수가 가능한 많아야 한다.
- 를 기준으로 문자열을 나눈 뒤
첫 수식을 뺀 '-' 뒤에 나오는 숫자들을 모두 뺀다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 문자열에 -가 포함된 경우
        if (str.contains("-")) {
            String[] strings = str.split("-");
            int result = 0;
            // 첫번째 수식들은 다 더해준다.
            String [] first = strings[0].split("\\+");
            for(String s : first){
                result += Integer.parseInt(s);
            }
            // 다음부터는 모두 빼준다.
            for (int i = 1; i < strings.length; i++) {
                String[] next = strings[i].split("\\+");
                for(String s : next){
                    result -= Integer.parseInt(s);
                }
            }
            System.out.println(result);
        } else {
            // -가 아예 없는 경우는 모두 더해준다.
            String [] plus = str.split("\\+");
            int result = 0;
            for(String s : plus){
                result += Integer.parseInt(s);
            }
            System.out.println(result);
        }
    }
}