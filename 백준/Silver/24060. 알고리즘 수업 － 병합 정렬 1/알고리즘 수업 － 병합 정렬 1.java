import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result = -1;
    static int cnt = 0;
    static int[] arr;
    static int[] tmp;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        k = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i <N ; i++) {
            arr [i] = sc.nextInt();
        }
        tmp = new int[N];
        mergeSort(arr, 0, N-1);
        System.out.println(result);
    }
    public static void mergeSort(int[] arr, int p, int r) {
        if(cnt > k) return;
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {

        int i = p;
        int j = q + 1;
        int t = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[t++] = arr[i++];
            } else {
                tmp[t++] = arr[j++];
            }
        }
        while (i <= q) {
            tmp[t++] = arr[i++];
        }
        while (j <= r) {
            tmp[t++] = arr[j++];}
            i = p;
            t = 0;

        while (i <= r) {
            cnt++;
            if(cnt ==k){
                result = tmp[t];
                break;
            }
            arr[i++] = tmp[t++];
        }
    }
}