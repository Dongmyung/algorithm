//import java.math.BigInteger;
import java.util.Arrays;

public class LV2_2개_이하로_다른_비트 {
    public static void main(String[] args) {
        LV2_2개_이하로_다른_비트 executor = new LV2_2개_이하로_다른_비트();
        long[] n = {1001,337,0,1,333,673,343,221,898,997,121,1015,665,779,891,421,222,256,512,128,100};
        // output : [1002, 338, 1, 2, 334, 674, 347, 222, 899, 998, 122, 1019, 666, 781, 893, 422, 223, 257, 513, 129, 101]
        long[] answer = executor.solution(n);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = getAnswer(numbers[i]);
        }
        return answer;
    }

    private long getAnswer(long number) {
        if (number % 2 == 0) return number + 1;

        long needToBeAdded = 1;
        while (true) {
            if ((number & needToBeAdded) == 0) break;
            needToBeAdded *= 2;
        }
        needToBeAdded /= 2;
        return number + needToBeAdded;
    }

//    private long getAnswer(long number) {
//        if (number % 2 == 0) return number+1;
//
//        int shift_count = 0;
//        while (true) {
//            if (((number >> shift_count) & 1) % 2 == 0) break;
//            shift_count++;
//        }
//        return number + new BigInteger("2").pow(shift_count-1).longValue();
//    }
}
