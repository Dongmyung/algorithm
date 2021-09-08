import java.util.*;

public class LV3_모두_0으로_만들기 {
    public static void main(String[] args) {
        LV3_모두_0으로_만들기 executor = new LV3_모두_0으로_만들기();
        int[] a = {-5,0,2,1,2};
        int[][] b= {{0,1},{3,4},{2,3},{0,3}};
        long answer = executor.solution(a, b);
        System.out.println("Answer : " + answer);
    }

    long count;
    boolean[] visited;
    ArrayList<Integer>[] children;
    long[] weight;
    public long solution(int[] a, int[][] edges) {
        this.count = 0;
        this.visited = new boolean[a.length];
        this.children = new ArrayList[a.length];
        this.weight = new long[a.length];

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            children[i] = new ArrayList<>();
            weight[i] = a[i];
        }
        if (sum != 0) return -1;

        for (int i = 0; i < edges.length; i++) {
            children[edges[i][0]].add(edges[i][1]);
            children[edges[i][1]].add(edges[i][0]);
        }

        dfs(0);

        return count;
    }

    private long dfs(int node) {
        visited[node] = true;
        for (int i = 0; i < children[node].size(); i++) {
            int child = children[node].get(i);
            if (!visited[child]) {
                weight[node] = dfs(child);
            }
        }
        this.count += Math.abs(weight[node]);
        return weight[node];
    }
}
