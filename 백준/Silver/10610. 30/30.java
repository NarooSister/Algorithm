import java.util.Arrays;
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
        // 오름차순 정렬
        Arrays.sort(chars);

        // 각 자리수를 모두 더한 수 구하기
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            tmp += chars[i];
        }
        // 0이 포함되어있으면서 모든 수를 더한 값을 3으로 나누면 0이 되는지 확인
        if(chars[0] == '0' && tmp%3 ==0){
            sb.append(chars).reverse(); // 뒤집어서 저장
        }else{
            sb.append("-1");
        }
        System.out.println(sb);
    }
}