import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> stringSet = new HashSet<>();
        int num = 0;
        while (num<=str.length()){
            for (int i = 0; i <= str.length(); i++) {
                if(i<num) {
                    stringSet.add(str.substring(i, num));
                }
            }
            num++;
        }
        System.out.println(stringSet.size());
    }
}