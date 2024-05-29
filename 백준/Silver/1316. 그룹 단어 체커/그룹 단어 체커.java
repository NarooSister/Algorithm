import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(groupCheck()){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean groupCheck() throws IOException{
        boolean[] check = new boolean[26];
        int prev = 0;  //이전 문자
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);  //i번째 문자
            //i번째 문자와 이전 문자가 다를 때
            if(prev != now){
                //처음 나오는 경우
                if(!check[now - 'a']){
                    check[now - 'a'] = true;
                    prev = now;

                //이전에 나온 적 있는 경우
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
