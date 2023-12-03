import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int [][] aryA = new int[N][M];
        int [][] aryB = new int[N][M];
        int [][] result= new int[N][M];

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                aryA[i][j] = sc.nextInt();

            }
        }
        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                aryB[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                result[i][j] =aryA[i][j]+aryB[i][j];
                System.out.print(result[i][j]+" ");
            }
        }
     }
}
