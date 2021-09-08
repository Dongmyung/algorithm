import java.util.Arrays;

public class LV3_110_옮기기 {
    public static void main(String[] args) {
        LV3_110_옮기기 executor = new LV3_110_옮기기();
        String[] s = {"1110","100111100","0111111010"};
        String[] answer = executor.solution(s);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            answer[i] = solve(s[i]);
        }
        return answer;
    }

    private String solve(String str) {
        char[] chars = new char[str.length()];
        int stackIdx = -1;
        int num110 = 0;
        for (int i = 0; i < str.length(); i++) {
            chars[++stackIdx] = str.charAt(i);
            if (stackIdx >= 2) {
                if (chars[stackIdx-2] == '1' && chars[stackIdx-1] == '1' && chars[stackIdx] == '0') {
                    stackIdx -= 3;
                    num110++;
                }
            }
        }

        boolean foundZero = false;
        int insertPos = stackIdx + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = stackIdx; i >= 0; i--) {
            sb.insert(0, chars[i]);
            if (!foundZero && chars[i] == '1') insertPos--;
            if (chars[i] == '0') foundZero = true;
        }
        for (int i = 0; i < num110; i++) {
            sb.insert(insertPos, "110");
        }
        return sb.toString();
    }
}
