import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

/*
1. 입력
네 정수 r1, c1, r2, c2

2. 출력
r2 -r1 +1개의 줄에 소용돌이를 예쁘게 출력한다.

3. 풀이


*/
public class Main {
    static int [][] map;
    static int r1, c1, r2, c2;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        map = new int[r2-r1+1][c2-c1+1];

        int maxNumber = 0;
        for (int i = r1; i <=r2 ; i++) {
            for (int j = c1; j <=c2 ; j++) {
                map[i-r1][j-c1] = spinalNumber(i,j);
                maxNumber = Math.max(maxNumber, map[i-r1][j-c1]);
            }
        }
        int maxLength = String.valueOf(maxNumber).length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r2-r1+1; i++) {
            for (int j = 0; j < c2-c1+1; j++) {
                sb.append(String.format("%"+maxLength+"d ", map[i][j]));
            }
            sb.setLength(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static int spinalNumber(int x, int y){
        int depth = Math.max(Math.abs(x), Math.abs(y));
        // 새로운 depth의 시작 수
        // = 이전 depth의 마지막 수 + 1 = (depth*2+1)(depth*2+1) + 1
        int startNumber = (2*depth-1)*(2*depth-1);

        if(x == depth){
            return startNumber + depth*7 + y;
        }else if(y == -depth){
            return startNumber + depth*5 + x;
        } else if(x == -depth){
            return startNumber + depth*3 - y;
        }
        return startNumber + depth  - x;
    }
}