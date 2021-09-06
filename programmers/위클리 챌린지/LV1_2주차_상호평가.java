class LV1_2주차_상호평가 {
  public String solution(int[][] scores) {
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < scores.length; col++) {
            int max = 0;
            int sum = 0;
            int min = 100;
            int count = scores.length - 1;
            for (int row = 0; row < scores.length; row++) {
                int val = scores[row][col];
                if (col != row) {
                    if (max < val) max = val;
                    if (min > val) min = val;
                    sum += val;
                }
            }
            if (min <= scores[col][col] && scores[col][col] <= max) {
                sum += scores[col][col];
                count++;
            }
            sb.append(calScore((double)sum / count));
        }
        return sb.toString();
    }
    
    private char calScore(double avg) {
        if (avg >= 90)  return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 50) return 'D';
        else return 'F';
    }
}
