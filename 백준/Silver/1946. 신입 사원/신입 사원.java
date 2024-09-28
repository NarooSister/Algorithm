import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            List<int[]> list = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                list.add(new int[]{sc.nextInt(), sc.nextInt()});
            }
            // 서류심사 성적 오름차순 정렬
            list.sort(Comparator.comparingInt(a -> a[0]));
            int result = 1;
            int minRank = list.get(0)[1];

            for (int j = 1; j < n; j++) {
                if(list.get(j)[1] < minRank){
                    result++;
                    minRank = list.get(j)[1];
                }
            }
            System.out.println(result);
        }
    }
}

