import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int [] save = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            save[i] = arr[i];
        }
        int max = save[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    save[i] = Math.max(save[i], save[j]+arr[i]);
                }
            }
            max = Math.max(max, save[i]);
        }
        System.out.println(max);
    }
}
