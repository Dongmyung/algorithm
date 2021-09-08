import java.util.Arrays;

public class LV2_쿼드압축_후_개수_세기 {
    public static void main(String[] args) {
        LV2_쿼드압축_후_개수_세기 executor = new LV2_쿼드압축_후_개수_세기();
        int[][] a = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[] answer = executor.solution(a);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    int numOne = 0;
    int numZero = 0;
    public int[] solution(int[][] arr) {
        int N = arr.length;

        // count all 1 num
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) numOne++;
            }
        }
        numZero = N * N - numOne;

        while (N > 1) {
            N /= 2;
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = getMergedValue(arr[i*2][j*2], arr[i*2][j*2+1], arr[i*2+1][j*2], arr[i*2+1][j*2+1]);
                }
            }
            arr = map;
        }

        int[] answer = {numZero, numOne};
        return answer;
    }

    private int getMergedValue(int n1, int n2, int n3, int n4) {
        if (n1 == n2 && n1 == n3 && n1 == n4){
            if (n1 == 1) numOne -= 3;
            else if (n1 == 0) numZero -= 3;
            return n1;
        }
        return -1;
    }
}
