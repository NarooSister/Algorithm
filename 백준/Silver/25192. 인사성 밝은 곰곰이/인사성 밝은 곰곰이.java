import java.util.HashSet;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        sc.nextLine();
        HashSet <String> strSet = new HashSet<>();
        for (int i = 1; i <=n; i++) {
            String str = sc.nextLine();
            if(str.equals("ENTER")){
                strSet.clear();
                continue;
            } else if(!strSet.contains(str)){
                strSet.add(str);
                result++;
            }}
        System.out.println(result);
    }
}