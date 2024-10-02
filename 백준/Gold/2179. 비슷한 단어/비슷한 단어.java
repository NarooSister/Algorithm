import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        int maxLength = -1; // 최대길이 접두사
        String a = "";
        String b = "";
        // 출력 시 index값에 따라 나열해야 하므로 
        // 이중 for문으로 다음 수와 비교한다.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                int length = commonLength(strings[i], strings[j]);
                if(length > maxLength){
                    maxLength = length;
                    a = strings[i];
                    b = strings[j];
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
    }
    // 두 문자열의 공통 길이 구하기 (몇번째 단어까지 같은지)
    static int commonLength(String a, String b) {
        int length = Math.min(a.length(), b.length());
        int idx = 0;
        while (idx < length && a.charAt(idx) == b.charAt(idx)) {
            idx++;
        }
        return idx;
    }
}