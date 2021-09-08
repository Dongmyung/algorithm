import java.util.Arrays;

public class LV3_풍선_터트리기 {
    public static void main(String[] args) {
        LV3_풍선_터트리기 executor = new LV3_풍선_터트리기();
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        int answer = executor.solution(a);
        System.out.println("Answer : " + answer);
    }

    public int solution(int[] a) {
        int answer = a.length;
        int cannotLeft = 0;
        int leftIdx = 0;
        int leftMin = a[leftIdx];
        int rightIdx = a.length-1;
        int rightMin = a[rightIdx];

        while (rightIdx - leftIdx > 1) {
            if (leftMin < rightMin) {
                rightIdx--;
                int target = a[rightIdx];
                if (target < rightMin) {
                    rightMin = target;
                } else {
                    cannotLeft++;
                }
            } else {
                leftIdx++;
                int target = a[leftIdx];
                if (target < leftMin) {
                    leftMin = target;
                } else {
                    cannotLeft++;
                }
            }
        }
        return answer - cannotLeft;
    }
}
