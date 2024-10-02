import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
/*
1. 입력
20줄의 과목명, 학점, 등급

2. 출력
학점*등급/학점 총합 출력
P인 경우는 제외

3. 풀이
등급마다 switch문으로 숫자로 바꿔준 뒤 더해서 나누었다.

*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result = 0;
        double totalScore =0;
        for (int i = 0; i < 20; i++) {
            String [] str = br.readLine().split(" ");
            double score = Double.parseDouble(str[1]);
            totalScore += score;
            
            String command = str[2];
            double grade = 0;
            switch (command){
                case "A+" : grade = 4.5; break;
                case "A0" : grade = 4.0; break;
                case "B+" : grade = 3.5; break;
                case "B0" : grade = 3.0; break;
                case "C+" : grade = 2.5; break;
                case "C0" : grade = 2.0; break;
                case "D+" : grade = 1.5; break;
                case "D0" : grade = 1.0; break;
                case "F" : grade = 0; break;
                case "P" : grade = -1; totalScore-=score; break;
            }
            if(grade!=-1){
                result += score*grade;
            }
        }
        System.out.printf("%4f", result/totalScore);
    }
}