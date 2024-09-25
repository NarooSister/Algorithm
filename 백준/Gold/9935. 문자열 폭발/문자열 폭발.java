import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        char [] result = new char[str.length()];    // char 배열 만들기
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {
            // 하나씩 넣으면서 폭탄인지 확인
            result[idx] = str.charAt(i);
            if(isBomb(result, idx, bomb)){
                idx -= bomb.length();
            }
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result, 0, idx);
        System.out.println(sb.isEmpty() ? "FRULA" : sb);
    }

    static boolean isBomb(char [] result, int idx, String bomb){
        // 인덱스가 폭탄 문자열보다 작으면 false
        if(idx < bomb.length()-1) return false;

        // result가 폭탄 문자열과 같지 않으면 false
        for (int i = 0; i < bomb.length(); i++) {
            if(result[idx -bomb.length()+1 +i] != bomb.charAt(i)) return false;
        }
        return true;
    }
}
