import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long time = 10; // daldidalgo + daldidan
        long count =0;  //daldidalgo 묶음의 개수
        while(n>1){
            n/=2;   // n을 2로 나눈 만큼 count++;
            count++;
        }

        System.out.println(time+count);
    }
}
