import java.util.*;

public class LV1_두_개_뽑아서_더하기 {
    public static void main(String[] args) {
        LV1_두_개_뽑아서_더하기 executor = new LV1_두_개_뽑아서_더하기();

        int[] a = {2,1,3,4,1};

        int[] answer = executor.solution(a);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] ret = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            ret[idx++] = i;
        }

        return ret;
    }
}
