class LV1_1주차_부족한_금액_계산하기{
    public long solution(int price, int money, int count) {
        long answer = (long)price * count * (count + 1) / 2 - money;
        if (answer <= 0) answer = 0;
        return answer;
    }
}
