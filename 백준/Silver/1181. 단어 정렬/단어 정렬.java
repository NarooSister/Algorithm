import java.io.*;
import java.util.*;

/*
1. 입력
n (좌표의 개수)
각 줄마다 단어 하나씩, n개 입력

2. 출력
길이가 짧은 것부터, 같으면 사전순으로 n개 출력

3. 문제 접근법
길이가 짧은것, 사전순으로 정렬

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }
        List<String> sortedStrings = new ArrayList<>(strings);

        // Comparator 만들어서 비교
        sortedStrings.sort((o1, o2) -> {
            // 길이 먼저 비교
            if(o1.length() != o2.length()){
                return o1.length() - o2.length();
            }
            // 이후 사전 순
            return o1.compareTo(o2);
        });

        for (String str : sortedStrings) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();
    }
}

