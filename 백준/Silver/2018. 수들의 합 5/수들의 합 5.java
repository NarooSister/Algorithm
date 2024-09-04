import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 1, end = 1, sum = 1, count = 1;
        while(start!=n){
            if(sum == n){
                count++;
                end++;
                sum += end;
            } else if(sum < n){
               end++;
               sum+= end;
            } else{
                sum-=start;
                start++;
            }
        }
        System.out.println(count);
    }
}
