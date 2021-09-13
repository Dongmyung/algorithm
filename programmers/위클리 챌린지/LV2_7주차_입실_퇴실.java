import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LV2_7주차_입실_퇴실 {
    public static void main(String[] args) {
        LV2_7주차_입실_퇴실 executor = new LV2_7주차_입실_퇴실();

        int[] enter = {1,4,2,3};
        int[] leave = {2,1,4,3};

        int[] answer = executor.solution(enter, leave);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public int[] solution(int[] enter, int[] leave) {
        Set<Integer> set = new HashSet<>();
        int[] count = new int[enter.length];
        int i = -1;
        int j = 0;
        while(j < leave.length) {
            if (set.contains(leave[j])) {
                set.remove(leave[j]);
                count[leave[j]-1] += set.size();
                for (int s : set) count[s-1]++;
                j++;
            } else {
                while (++i < enter.length) {
                    set.add(enter[i]);
                    if (enter[i] == leave[j]) break;
                }
            }
        }
        return count;
    }
}
