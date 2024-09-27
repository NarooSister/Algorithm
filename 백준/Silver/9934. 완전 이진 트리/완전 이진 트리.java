import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static ArrayList<Integer>[] levels; // 레벨별로 배열을 저장하는 리스트
    static int[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int size = (int) (Math.pow(2, k) -1);   // 총 노드의 개수
        nodes = new int[size];  // 노드 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        levels = new ArrayList[k+1];    // 노드 배열이 들어갈 List
        for (int i = 0; i < k; i++) {
            levels[i] = new ArrayList<>();  // 레벨별로 빈 배열 생성
        }
        
        inOrder(0,size-1,0);    // 중위 순회 트리

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < levels[i].size(); j++) {
                bw.write(levels[i].get(j)+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void inOrder(int start, int end, int depth){
        if(start> end){
            return;
        }
        int mid = (start + end) / 2 ;   // 루트 구하기
        levels[depth].add(nodes[mid]);  // list에 넣기
        inOrder(start, mid-1, depth+1);  // 왼쪽 노드 순회
        inOrder(mid+1, end, depth+1);   // 오른쪽 노드 순회
    }

}

