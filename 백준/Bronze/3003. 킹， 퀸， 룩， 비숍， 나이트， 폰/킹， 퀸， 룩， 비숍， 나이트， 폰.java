import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int king = sc.nextInt();
        int queen = sc.nextInt();
        int rook = sc.nextInt();
        int bishop = sc.nextInt();
        int night = sc.nextInt();
        int pawn = sc.nextInt();
        System.out.println((1- king) + " " + (1-queen) + " " +  (2-rook) + " "+ (2-bishop) +" " + (2-night) +" "+ (8-pawn));
    }
}