import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> file = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            //.의 인덱스 구해서 그 뒷부분만 자르기
            int idx = str.indexOf(".");
            String newStr = str.substring(idx+1);
            // map에 넣기, 중복인 경우 value++;
            if(file.containsKey(newStr)){
                file.put(newStr, file.get(newStr)+1);
            } else {
                file.put(newStr, 1);
            }
        }
        // 사전순으로 정렬하기 위해서 keySet으로 List에 넣는다
        List<String> keySet = new ArrayList<>(file.keySet());
        Collections.sort(keySet);
        for (String key : keySet) {
            Integer value = file.get(key);
            System.out.println(key + " " + value);
        }
    }
}