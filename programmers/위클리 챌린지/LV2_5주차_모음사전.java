class LV2_5주차_모음사전 {
    char[] chars = {'A', 'E', 'I', 'O', 'U' };

    public int solution(String word) {
        int answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == chars[0]) continue;
            int temp = 0;
            for (int k = 0; k < chars.length-i; k++) {
                temp += Math.pow(chars.length, k);
            }
            answer += temp * getIdx(c);
        }
        return answer;
    }

    private int getIdx(char c) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) return i;
        }
        return -1;
    }
}
