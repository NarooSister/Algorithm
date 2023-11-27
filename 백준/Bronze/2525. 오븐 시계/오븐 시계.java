import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();   //현재 시
        int b = sc.nextInt();   //현재 분
        int c = sc.nextInt();   //추가되는 분
        
        int hour = (a +(b+c)/60)%24;  //끝나는 시
        int min = (b+c)%60;   //끝나는 분

        System.out.println(hour+" "+min);
        }
    }