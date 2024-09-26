import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Map<String, Integer> cloth = new HashMap<>();
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 이름은 필요 없음
                String type = st.nextToken();
                cloth.put(type, cloth.getOrDefault(type,0)+1);  // Map에 종류별로 추가
            }

            int result = 1;
            for (int count : cloth.values()){   // value 돌면서 (의상수+1) 곱해주기
                result *= count + 1;
            }
            result -= 1;    // 알몸인 경우 빼주기
            System.out.println(result);
        }


    }

}
