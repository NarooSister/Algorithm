import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
         int[] ary9 = new int[9];
         int max = 0;
         int index = 0;
        for (int i = 0; i <9 ; i++) {
            ary9[i] = sc.nextInt();
        }
        for (int i = 0; i <9 ; i++) {
            if(ary9 [i]>max){
                max=ary9[i];
                if(true){
                    index = i;
            }}
        }
        System.out.println(max);
        System.out.println(index+1);
    }
}
