import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while((str = br.readLine())!=null){
            int n = Integer.parseInt(str);
            System.out.println(replace(n));
        }
        System.out.println(sb);
    }
    static String replace(int n){
       if(n==0){
           return "-";
       }
       String previous = replace(n-1);
       return previous + " ".repeat(previous.length())+previous;
    }
}