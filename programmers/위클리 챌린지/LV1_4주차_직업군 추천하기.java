import java.util.HashMap;
import java.util.Map;

class LV1_4주차_직업군 추천하기 {
    Map<String, Map<String, Integer>> scoreTable;

    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";

        scoreTable = new HashMap<>();

        for (String tableStr : table) {
            String[] temp = tableStr.split(" ");
            String jobType = temp[0];
            for (int i = 1; i < temp.length; i++) {
                String lang = temp[i];
                int point = temp.length - i;

                if (!scoreTable.containsKey(jobType)) {
                    scoreTable.put(jobType, new HashMap<>());
                }
                Map<String, Integer> map = scoreTable.get(jobType);
                map.put(lang, point);
            }
        }

        int maxScore = 0;
        for (String jobType : scoreTable.keySet()) {
            int score = getScore(jobType, languages, preference);
            if (maxScore < score || (maxScore == score && answer.compareTo(jobType) > 0)) {
                maxScore = score;
                answer = jobType;
            }
        }

        return answer;
    }

    private int getScore(String jobType, String[] languages, int[] preference) {
        int score = 0;
        for (int i = 0; i < languages.length; i++) {
            if (scoreTable.containsKey(jobType)) {
                Map<String, Integer> scoreMap = scoreTable.get(jobType);
                if (scoreMap.containsKey(languages[i])) {
                    score += scoreMap.get(languages[i]) * preference[i];
                }
            }
        }
        return score;
    }
}
