import java.util.*;

public class LV1_6주차_복서_정렬하기 {
    public static void main(String[] args) {
        LV1_6주차_복서_정렬하기 executor = new LV1_6주차_복서_정렬하기();

        int[] w = {50,82,75,120};
        String[] h2h = {"NLWL","WNLL","LWNW","WWLN"};

        int[] answer = executor.solution(w, h2h);
        System.out.println("Answer : " + Arrays.toString(answer));
    }


    public int[] solution(int[] weights, String[] head2head) {
        int numBoxers = weights.length;

        int[] winNum = new int[numBoxers];
        int[] matchNum = new int[numBoxers];
        int[] winHeavier = new int[numBoxers];

        // Calculate win_rate
        for (int i = 0; i < numBoxers; i++) {
            for (int j = i + 1; j < numBoxers; j++) {
                int boxer_1 = i;
                int boxer_2 = j;
                char resultMatch = head2head[i].charAt(j);
                if (resultMatch == 'N') continue;
                matchNum[i]++;
                matchNum[j]++;
                if (resultMatch == 'W') {
                    // boxer1 win , boxer2 lose
                    winNum[i]++;
                    if (weights[i] < weights[j]) winHeavier[i]++;
                } else {
                    // boxer1 lose, boxer2 win
                    winNum[j]++;
                    if (weights[j] < weights[i]) winHeavier[j]++;
                }
            }
        }

        // Make boxer list
        List<Boxer> boxers = new ArrayList<>(numBoxers);
        for (int i = 0; i < weights.length; i++) {
            boxers.add(new Boxer(i+1, weights[i], (matchNum[i] > 0 ? (float)winNum[i] / matchNum[i] : 0), winHeavier[i]));
        }

        // sort
        Collections.sort(boxers, new Comparator<Boxer>() {
            @Override
            public int compare(Boxer b1, Boxer b2) {
                if (b1.winRate > b2.winRate) return -1;
                else if (b1.winRate < b2.winRate) return 1;

                if (b1.winHeavier != b2.winHeavier) return b2.winHeavier - b1.winHeavier;

                if (b1.weight != b2.weight) return b2.weight - b1.weight;

                return b1.no - b2.no;
            }
        });

        return boxers.stream().mapToInt(boxer -> boxer.no).toArray();
    }

    private class Boxer {
        private int no;
        private int weight;
        private float winRate;
        private int winHeavier;

        public Boxer(int no, int weight, float winRate, int winHeavier) {
            this.no = no;
            this.weight = weight;
            this.winRate = winRate;
            this.winHeavier = winHeavier;
        }
    }
}
