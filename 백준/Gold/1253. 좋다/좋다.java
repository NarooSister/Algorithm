import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int good = 0;
        for (int i = 0; i < n; i++) {
            if (isGood(numbers, i)) {
                good++;
            }
        }

        bw.write(String.valueOf(good));
        bw.flush();
        bw.close();
    }

    static boolean isGood(int[] numbers, int idx) {
        int current = numbers[idx];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
                if(left == idx){
                    left++;
                    continue;
                }
                if(right == idx){
                    right --;
                    continue;
                }
                int sum = numbers[left]+ numbers[right];

                if(sum == current){
                    return true;
                } else if(sum < current){
                    left++;
                } else {
                    right--;
                }
        }
        return false;
    }
}

