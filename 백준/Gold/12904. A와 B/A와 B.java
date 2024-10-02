import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 입력
문자열 S
문자열 T

2. 출력
S를 T로 바꿀 수 있으면 1, 없으면 0

3. 풀이
가능한 연산
1. 문자열 뒤에 A 추가
2. 문자열을 뒤집고 뒤에 B를 추가

T에서부터 거꾸로 S로 탐색하면 루트는 하나뿐이다.

*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        while (t.length() > s.length()){
            if(t.charAt(t.length() -1 ) == 'A'){
                t = t.substring( 0, t.length() - 1);
            } else {
                t = new StringBuilder(t.substring(0, t.length() - 1)).reverse().toString();
            }
        }
        
        if(t.equals(s)){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}