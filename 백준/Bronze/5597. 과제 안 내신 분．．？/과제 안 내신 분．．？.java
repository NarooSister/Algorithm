import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> aryAll = new ArrayList<>();
        ArrayList<Integer> ary28 = new ArrayList<>();
        for (int i = 1; i <=30 ; i++) {
            aryAll.add(i);
        }
        for (int i = 0; i <28 ; i++) {
            int n = sc.nextInt();
            ary28.add(n);
        }
        aryAll.removeAll(ary28);
        if(aryAll.get(0)>aryAll.get(1)){
            System.out.println(aryAll.get(1));
            System.out.println(aryAll.get(0));
        } else {
            System.out.println(aryAll.get(0));
            System.out.println(aryAll.get(1));
        }
    }
}
