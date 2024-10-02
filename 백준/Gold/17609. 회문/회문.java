import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1. 입력
문자열의 개수 t
n줄 동안 문자열

2. 출력
각 문자열이 회문이면 0, 유사 회문이면 1, 둘 다 아니면 2를 각 줄에 출력

3. 풀이


*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(isPalindrome(str, 0, str.length() -1)){
                bw.write(0 + "\n");
            } else if(isPseudoPalindrome(str)){
                bw.write(1 + "\n");
            }else {
                bw.write(2 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
    private static boolean isPalindrome(String str, int left, int right) {
        while (left<right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            } else{
                return false;
            }}
        return true;
    }

    private static boolean isPseudoPalindrome(String str) {
       int left = 0;
       int right = str.length() -1;
       while(left<right){
           if(str.charAt(left) != str.charAt(right)){
               return isPalindrome(str, left+1, right) || isPalindrome(str, left, right-1);
           }
           left++;
           right--;
       }
        return false;
    }

}