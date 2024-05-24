import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        String S = br.readLine();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (arr[ch - 'a'] == -1) {
                arr[ch - 'a'] = i;
            }
        }
        for(int a :arr){
            System.out.print(a + " ");
        }
    }
}