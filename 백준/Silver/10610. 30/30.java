import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
1. 입력
양수 N

2. 출력
수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수 만들어서 출력

3. 풀이
30의 배수 만들기.
10의 배수여야 하고(끝자리 0), 3의 배수여야 한다.
3의 배수 = 각 자리수의 합이 3의 배수이면 이 수는 3의 배수이다.

*/
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String str = sc.nextLine();
        char [] chars = str.toCharArray();
        Arrays.sort(chars);

        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            tmp += chars[i];
        }
        if(chars[0] == '0' && tmp%3 ==0){
            sb.append(chars).reverse();
        }else{
            sb.append("-1");
        }
        System.out.println(sb);
    }
}