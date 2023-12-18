import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Map <String, String> log = new HashMap<>();
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            log.put(st.nextToken(), st.nextToken());
        }
        List<String> keySet = new ArrayList<>(log.keySet());
        Collections.sort(keySet, Collections.reverseOrder());

        for (String key : keySet){
            if(log.get(key).equals("enter")){
                System.out.println(key);
            }
        }
    }
}