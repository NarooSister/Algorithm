import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] A = new int[N];
        int max = -1000000;
        int min = 1000000;
        for (int i = 0; i <N ; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i <N ; i++) {
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}