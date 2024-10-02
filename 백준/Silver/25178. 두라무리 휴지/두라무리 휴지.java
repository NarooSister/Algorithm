import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();
        boolean isGood = false;

        if (a.charAt(0) == b.charAt(0) && a.charAt(n - 1) == b.charAt(n - 1)) {
            String replaceA = a.replaceAll("[aeiou]", "");
            String replaceB = b.replaceAll("[aeiou]", "");
            if (replaceA.equals(replaceB)) {
                char[] sortedA = a.toCharArray();
                char[] sortedB = b.toCharArray();
                Arrays.sort(sortedA);
                Arrays.sort(sortedB);

                if (Arrays.equals(sortedA, sortedB)) {
                    isGood = true;
                }
            }
        }

        if (isGood) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}