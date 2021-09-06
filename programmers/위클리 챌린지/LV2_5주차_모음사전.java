import java.util.ArrayList;
import java.util.List;

class LV2_5주차_모음사전 {
    final int MAX_WORD_LENGTH = 5;
    char[] chars = {'A', 'E', 'I', 'O', 'U' };
    List<String> data;

    public int solution(String word) {
        int answer = 0;
        data = new ArrayList<>(10000);
        for (int i = 0; i < chars.length; i++) {
            addStringToData("", chars[i]);
        }
        return data.indexOf(word)+1;
    }

    private void addStringToData(String s, char c) {
        if (s.length() >= 5) return;
        String str = s + c;
        data.add(str);
        for (int i = 0; i < chars.length; i++) {
            addStringToData(str, chars[i]);
        }
    }

    private int getIdx(char c) {
        char[] data = {' ', 'A', 'E', 'I', 'O', 'U' };
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) return i;
        }
        return -1;
    }
}
