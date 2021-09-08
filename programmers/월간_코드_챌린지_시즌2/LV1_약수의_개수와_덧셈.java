public class LV1_약수의_개수와_덧셈 {
    public static void main(String[] args) {
        LV1_약수의_개수와_덧셈 executor = new LV1_약수의_개수와_덧셈();
        int l = 13;
        int r = 17;
        int answer = executor.solution(l, r);
        System.out.println("Answer : " + answer);
    }

    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer += i * (getNumDivisor(i) % 2 == 0 ? 1 : -1);
        }
        return answer;
    }

    private int getNumDivisor(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num == i * i) count++;
                else count += 2;
            }
        }
        return count;
    }
}
