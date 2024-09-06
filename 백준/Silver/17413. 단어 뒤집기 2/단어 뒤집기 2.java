import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        String str = br.readLine();
        int idx = 0;

        while (idx < str.length()) {
            // < 를 만났을 때
            if (str.charAt(idx) == '<') {
                int closeIdx = str.indexOf('>', idx);   // '>' 구함
                sb.append(str, idx, closeIdx + 1);  // '>' 전까지 넣어줌
                idx = closeIdx+1;   // idx 증가

            } else {
                // 1. 다음 태그가 없다면 문자열에 넣고 끝
                // 2. 태그가 있다면 다음 태그 전까지 공백 기준으로 나눠서 뒤집기

                int tagIdx = str.indexOf('<', idx);
                // 다음 태그 없을 때
                if(tagIdx == -1) {
                    String[] splitStr = str.substring(idx).split(" ");
                    for (String s : splitStr) {
                        reverse.append(s).reverse().append(" ");
                        sb.append(reverse);
                        reverse.setLength(0);
                    }
                    break;
                } else {
                    //다음 태그가 있다면 그 전까지 공백 기준으로 나눠서 돌려서 넣고 idx 변경
                    String[] splitStr = str.substring(idx, tagIdx).split(" ");
                    for (int i = 0; i < splitStr.length; i++) {
                        // 마지막에는 공백 넣지 않기
                        if(i == splitStr.length-1){
                            reverse.append(splitStr[i]).reverse();
                        } else {
                            reverse.append(splitStr[i]).reverse().append(" ");
                        }
                        sb.append(reverse);
                        reverse.setLength(0);
                    }
                    idx = tagIdx;
                }
            }
        }
        System.out.println(sb);
    }
}