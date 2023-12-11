import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int aryX[] = new int[4];
      int aryY[] = new int[4];
        int X,Y;

        for (int i = 0; i <3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            aryX[i] = Integer.parseInt(st.nextToken());
            aryY[i] = Integer.parseInt(st.nextToken());
        }

        if(aryX[0] == aryX[1]){
            X = aryX[2];
        } else if
            (aryX[0] == aryX[2]) {
                X = aryX[1];
            } else {
                X = aryX[0];
            }

        if(aryY[0] == aryY[1]){
            Y = aryY[2];
        } else if
        (aryY[0] == aryY[2]) {
            Y = aryY[1];
        } else {
           Y = aryY[0];
        }
        System.out.println(X+" "+Y);
        }
    }