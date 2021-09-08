import java.util.Stack;

public class LV2_괄호_회전하기 {
    public static void main(String[] args) {
        LV2_괄호_회전하기 executor = new LV2_괄호_회전하기();
        String s = "}]()[{";
        int answer = executor.solution(s);
        System.out.println("Answer : " + answer);
    }

    public int solution(String s) {
        int answer = 0;
        int n = 0;
        while(0 == (answer = getNumRightBracket(s))) {
            if (++n == s.length()) break;
            s = s.substring(1) + s.charAt(0);
        }
        return answer;
    }

    private int getNumRightBracket(String s) {
        Stack<Character> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && checkMatchingBracket(stack.peek(), c)) {
                stack.pop();
                if (stack.isEmpty()) num++;
            } else {
                stack.push(c);
            }
        }
        if (!stack.isEmpty()) num = 0;
        return num;
    }

    private boolean checkMatchingBracket(char c1, char c2) {
        if (c1 == '[' && c2 == ']') return true;
        if (c1 == '{' && c2 == '}') return true;
        if (c1 == '(' && c2 == ')') return true;
        return false;
    }
}
