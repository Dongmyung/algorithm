import java.util.Arrays;

public class LV2_삼각_달팽이 {
    public static void main(String[] args) {
        LV2_삼각_달팽이 executor = new LV2_삼각_달팽이();
        int a = 6;
        int[] answer = executor.solution(a);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public int[] solution(int n) {
        int[] answer = new int[(n + 1) * n / 2];
        int cur = 1;
        int row = -1;
        int col = 0;

        for (int i = n; i > 0; i -= 3) {
            for (int j = 0; j < i; j++) {
                // Down
                row++;
                answer[(row+1)*row/2+col] = cur++;
            }
            for (int j = 0; j < i-1; j++) {
                // Right
                col++;
                answer[(row+1)*row/2+col] = cur++;
            }
            for (int j = 0; j < i-2; j++) {
                // Up & Left
                row--;
                col--;
                answer[(row+1)*row/2+col] = cur++;
            }
        }
        return answer;
    }
}
