public class LV3_스타_수열 {
    public static void main(String[] args) {
        LV3_스타_수열 executor = new LV3_스타_수열();

        int[] a = {0,3,3,0,7,2,0,2,2,0};

        int answer = executor.solution(a);
        System.out.println("Answer : " + answer);
    }

    public int solution(int[] a) {
        int answer = 0;

        int[] count = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) continue;
            if (count[i] <= answer) continue;

            int countCommon = 0;
            for (int j = 0; j < a.length-1; j++) {
                if (a[j] == a[j+1]) continue;
                if (a[j] != i && a[j+1] != i) continue;
                countCommon++;
                j++;
            }
            answer = Math.max(countCommon, answer);
        }
        return answer * 2;
    }
}
