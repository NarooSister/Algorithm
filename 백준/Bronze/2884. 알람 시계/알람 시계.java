import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        if (h==0 && m<45){
            m = m+15;
            System.out.println(23+" "+m);
        } else if(h>=0 && h<=23 && m == 45){
            System.out.println(h+" "+0);
        } else if (h>0 && h<=23 && m<45){
            m=m+15;
            System.out.println(h-1+" "+m);
        } else{
            m = m-45;
            System.out.println(h+" "+m);
        }
    }
}
