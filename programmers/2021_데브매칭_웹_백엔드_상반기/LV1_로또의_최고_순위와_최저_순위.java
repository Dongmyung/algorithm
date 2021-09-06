import java.util.Arrays;

public class LV1_로또의_최고_순위와_최저_순위 {
    public static void main(String[] args) {
        LV1_로또의_최고_순위와_최저_순위 executor = new LV1_로또의_최고_순위와_최저_순위();

        int[] l = {44, 1, 0, 0, 31, 25};
        int[] w = {31, 10, 45, 1, 6, 19};

        int[] answer = executor.solution(l, w);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int matched = 0;
        int unrecognized = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                unrecognized++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    matched++;
                    break;
                }
            }
        }
        return new int[]{getRank(matched + unrecognized), getRank(matched) };
    }

    private int getRank(int matched) {
        if (matched < 2) return 6;
        else return 7 - matched;
    }

}
