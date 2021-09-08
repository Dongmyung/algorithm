public class LV1_내적 {
    public static void main(String[] args) {
        LV1_내적 executor = new LV1_내적();

        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};

        int answer = executor.solution(a, b);
        System.out.println("Answer : " + answer);
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
