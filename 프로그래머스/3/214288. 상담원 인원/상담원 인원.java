import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        List<List<int[]>> timeType = new ArrayList<>();
        
        for(int i = 0; i <= k; i++){
            timeType.add(new ArrayList<>());
        }
        
        for(int[] req : reqs){
            int start = req[0];
            int end = start + req[1];
            int type = req[2];
            timeType.get(type).add(new int[]{start, end});
        }
        
        int[][] gapTable = new int[k+1][n-k+1];
        for(int i = 1; i <= k; i++){
            calcTime(gapTable[i], timeType.get(i));
        }
        
        return getMinTime(n-k, gapTable, 1);
    }
    
    // 상담원 수에 따른 대기 시간 
    static void calcTime(int[] gapTable, List<int[]> timeType){
        for(int i=0; i < gapTable.length; i++){
            int maxMentor = i+1;
            int count = 0;
            int gapTotal = 0;
            
            PriorityQueue<Integer> endQ = new PriorityQueue<>();
            for (int[] time : timeType) {
                int nowStart = time[0];
                int nowEnd = time[1];
                
                while (!endQ.isEmpty() && nowStart >= endQ.peek()) {
                    endQ.poll();
                    count--;
                }
                
                if (endQ.isEmpty() || nowStart < endQ.peek()) {
                    count++;
                }
                
                if (count > maxMentor) {
                    int gap = endQ.poll() - nowStart;
                    nowEnd += gap;
                    gapTotal += gap;
                    count--;
                }
                endQ.add(nowEnd);
            }
            gapTable[i] = gapTotal;
        }
    }
    
    // 대기 시간이 최소가 되는 조합 찾기
    static int getMinTime(int maxMentor, int[][] gapTable, int type){
        int minTotal = Integer.MAX_VALUE;
        for(int i = 0; i <= maxMentor; i++){
            int value = gapTable[type][i];
            if(type < gapTable.length -1){
                value += getMinTime(maxMentor-i, gapTable, type+1);
            }
            minTotal = Math.min(minTotal, value);
        }
        return minTotal;
    }
}
