import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       while(true){
           int n = Integer.parseInt(br.readLine());
           StringBuilder sb = new StringBuilder();
           if(n ==-1) break;
           int sum = 0;
           for (int i = 1; i <n ; i++) {
               if(n%i == 0){
                  sb.append(i + " + ");
                   sum += i;
               }
           }
           if(n==sum){
               System.out.println(n+" = "+sb.toString().substring(0,sb.length()-3));
           } else{
               System.out.println(n+" is NOT perfect.");
           }
       }
    }
}

