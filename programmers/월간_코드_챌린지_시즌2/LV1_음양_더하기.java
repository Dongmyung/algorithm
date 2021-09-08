public class LV1_음양_더하기 {
    public static void main(String[] args) {
        LV1_음양_더하기 executor = new LV1_음양_더하기();
        int[] a = {4,7,12};
        boolean[] s = {true,false,true};
        int answer = executor.solution(a, s);
        System.out.println("Answer : " + answer);
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
            answer += absolutes[i] * (signs[i] ? 1 : -1);
        }
        return answer;
    }
}
