import java.util.Arrays;

public class LV2_이진_변환_반복하기 {
    public static void main(String[] args) {
        LV2_이진_변환_반복하기 executor = new LV2_이진_변환_반복하기();
        String a = "110010101001";
        int[] answer = executor.solution(a);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public int[] solution(String s) {
        int numStep = 0;
        int numZero = 0;

        while (!s.equals("1")) {
            int tempNumZero = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    tempNumZero++;
                }
            }
            s = Integer.toBinaryString(s.length() - tempNumZero);
            numStep++;
            numZero += tempNumZero;
        }

        int[] answer = {numStep, numZero};
        return answer;
    }
}
