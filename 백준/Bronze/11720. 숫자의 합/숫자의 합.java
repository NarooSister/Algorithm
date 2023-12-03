import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String numN = sc.next();
        int [] intNum= new int[number];
        int result=0;
        for (int i = 0; i <number ; i++) {
            numN.charAt(i);
           intNum[i] = numN.charAt(i);
            result += intNum[i]-48;
        }
        System.out.println(result);
    }
}
