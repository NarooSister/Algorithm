import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());
        int tree = Integer.parseInt(st.nextToken());

        if ((tree-down)%(up-down)==0){
            System.out.println((tree-down)/(up-down));
        } else{
            System.out.println(((tree-down)/(up-down))+1);
        }
    }
}