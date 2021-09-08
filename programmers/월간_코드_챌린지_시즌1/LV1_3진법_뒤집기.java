public class LV1_3진법_뒤집기 {
    public static void main(String[] args) {
        LV1_3진법_뒤집기 executor = new LV1_3진법_뒤집기();

        int n = 125;

        int answer = executor.solution(n);
        System.out.println("Answer : " + answer);
    }

    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(sb.toString(), 3);
    }

}
