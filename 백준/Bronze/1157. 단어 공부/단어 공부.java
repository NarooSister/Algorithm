import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        str = str.toUpperCase();

        int [] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - 'A';
            arr[a]++;
        }
        
        int max = 0;
        char result = '?';
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
                result = (char)(i+'A');
            } else if (max == arr[i]) {
                result = '?';
            }
        }
        System.out.println(result);
    }
}
