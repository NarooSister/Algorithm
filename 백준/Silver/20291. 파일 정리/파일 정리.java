import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> file = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            //.의 인덱스 구해서 그 뒷부분만 자르기
            int idx = str.indexOf(".");
            String newStr = str.substring(idx+1);
            // map에 넣기, 중복인 경우 value++;
            file.put(newStr, file.getOrDefault(newStr, 0)+1);
        }
        for (Map.Entry<String, Integer> entry : file.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}