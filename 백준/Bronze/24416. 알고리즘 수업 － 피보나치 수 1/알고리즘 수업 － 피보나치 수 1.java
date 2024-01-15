import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      fib(n);
      fibonacci(n);
      System.out.println(result1+" "+result2);
   }
   public static int result1;
   public static int result2;
   public static int fib(int n){
      if(n==1 || n==2){
         result1++;
      return 1;
      } else{
         return(fib(n-1) + fib(n-2));
      }
   }
   public static int fibonacci(int n){
      int [] arr = new int [n+1];
      arr[1] = arr[2] = 1;
      for (int i = 3; i <= n ; i++) {
         result2++;
         arr[i] = arr[i-1] + arr[i-2];
      }
      return arr[n];
   }
}