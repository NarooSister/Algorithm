import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int A [][] = new int[9][9];
        int max = 0;
        int maxI=0;
        int maxJ=0;
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                A [i][j] = sc.nextInt();
                if(A[i][j]>=max){
                    max=A[i][j];
                    maxI=i+1;
                    maxJ=j+1;
                }
            }
        }System.out.println(max);
        System.out.println(maxI +" "+maxJ);
    }
}
