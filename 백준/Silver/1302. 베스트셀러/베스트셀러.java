import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 사전순으로 넣어두기 위해 TreeMap 사용
        // Map<책 이름, 판매 부수> 로 저장
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0)+1);
        }

        // 가장 큰 value값 찾기
        Collection<Integer> values = map.values();
        int idx = 0;
        for (Integer value : values) {
            if(value >= idx){
                idx = value;
            }
        }

        // 가장 큰 value 값으로 첫 key값 찾기
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (map.get(key) == idx) {
                System.out.println(key);
                break;
            }
        }
    }
}