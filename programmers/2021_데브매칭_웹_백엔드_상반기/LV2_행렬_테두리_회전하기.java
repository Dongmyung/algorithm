import java.util.Arrays;

public class LV2_행렬_테두리_회전하기 {
    public static void main(String[] args) {
        LV2_행렬_테두리_회전하기 executor = new LV2_행렬_테두리_회전하기();

        int r = 3;
        int c = 3;
        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        int[] answer = executor.solution(r, c, queries);
        System.out.println("Answer : " + Arrays.toString(answer));
    }

    int[][] matrix;
    public int[] solution(int rows, int columns, int[][] queries) {
        this.matrix = new int[rows][columns];
        int[] answer = new int[queries.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    private int rotate(int[] query) {
        int row_top = query[0] - 1;
        int col_start = query[1] - 1;
        int row_bottom = query[2] - 1;
        int col_end = query[3] - 1;

        int temp = this.matrix[row_top][col_start];
        int min = temp;
        for (int i = row_top; i < row_bottom; i++) {
            this.matrix[i][col_start] = this.matrix[i+1][col_start];
            min = Math.min(min, this.matrix[i][col_start]);
        }
        for (int j = col_start; j < col_end; j++) {
            this.matrix[row_bottom][j] = this.matrix[row_bottom][j+1];
            min = Math.min(min, this.matrix[row_bottom][j]);
        }
        for (int i = row_bottom; i > row_top; i--) {
            this.matrix[i][col_end] = this.matrix[i-1][col_end];
            min = Math.min(min, this.matrix[i][col_end]);
        }
        for (int j = col_end; j > col_start; j--) {
            this.matrix[row_top][j] = this.matrix[row_top][j-1];
            min = Math.min(min, this.matrix[row_top][j]);
        }
        this.matrix[row_top][col_start+1] = temp;

        return min;
    }
}
