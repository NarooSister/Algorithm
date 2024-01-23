import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int[10];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            arr [i] = Integer.parseInt(br.readLine());
            set.add(arr[i]%42);
        }
        System.out.println(set.size());
    }
}