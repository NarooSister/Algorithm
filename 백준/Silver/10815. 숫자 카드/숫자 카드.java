import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            arr [i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <M; ++i) {
            sb.append(binarySearch(N, arr, Integer.parseInt(st.nextToken()))+" ");
        }
        System.out.println(sb.toString());

    }
    public static int binarySearch(int N, int arr[] ,int target){
        int left=0;
        int right=N-1;

        while(left<=right){
            int mid= left+(right-left)/ 2;
            if(arr[mid]==target){
                return 1;
            } else if (arr[mid]<target) {
                left = mid + 1 ;
            } else{
                right = mid - 1 ;
            }
        }
        return 0;
    }
}