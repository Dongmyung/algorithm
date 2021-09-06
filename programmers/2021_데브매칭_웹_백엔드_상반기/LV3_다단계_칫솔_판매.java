import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LV3_다단계_칫솔_판매 {
    public static void main(String[] args) {
        LV3_다단계_칫솔_판매 executor = new LV3_다단계_칫솔_판매();

        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] answer = executor.solution(enroll, referral, seller, amount);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    private final int PROFIT_PER_PRODUCT = 100;
    Map<String, Integer> distributedProfitMap;
    Map<String, String> referralMap;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] distributedProfit = new int[enroll.length];
        referralMap = new HashMap<>();
        distributedProfitMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            referralMap.put(enroll[i], referral[i]);
        }
        for (int i = 0; i < seller.length; i++) {
            distributeProfit(seller[i], amount[i] * PROFIT_PER_PRODUCT);
        }
        for (int i = 0; i < enroll.length; i++) {
            distributedProfit[i] = distributedProfitMap.getOrDefault(enroll[i], 0);
        }
        return distributedProfit;
    }

    private void distributeProfit(String seller, int profit) {
        int referralProfit = profit / 10;
        int curProfit = distributedProfitMap.getOrDefault(seller, 0);
        distributedProfitMap.put(seller, curProfit + profit - referralProfit);
        if (referralProfit > 0) {
            String referralSeller = referralMap.get(seller);
            if (!referralMap.get(seller).equals("-")) {
                distributeProfit(referralSeller, referralProfit);
            }
        }
    }
}
