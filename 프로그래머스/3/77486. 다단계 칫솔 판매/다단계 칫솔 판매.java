import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> referralMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();
        
        for(String name : enroll){
            profitMap.put(name, 0);
        }
        
        for(int i=0; i < enroll.length; i++){
            referralMap.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++){
            String currentSeller = seller[i];
            int totalProfit = amount[i] * 100;
            profitRule(currentSeller, totalProfit, referralMap, profitMap);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = profitMap.get(enroll[i]);
        }
        return answer;
    }
    
    private void profitRule(String seller, int profit, Map<String, String> referralMap, Map<String, Integer> profitMap){
        if(seller.equals("-") || profit < 1){
            return;
        }
        
        int referralProfit = profit / 10;
        int sellerProfit = profit - referralProfit;
        
        profitMap.put(seller, profitMap.get(seller)+ sellerProfit);
        
        profitRule(referralMap.get(seller), referralProfit, referralMap, profitMap);
        
    }
}
