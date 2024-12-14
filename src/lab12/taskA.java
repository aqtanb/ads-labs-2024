package lab12; // floyd

import java.io.*;
import java.util.*;

public class taskA {
    private static final int MAXN = 501;
    private int n;
    private int[][] matrix = new int[MAXN][MAXN];
    private int[] x = new int[MAXN];
    private boolean[] used = new boolean[MAXN];
    private List<Integer> ans = new ArrayList<>();

    public void readInput(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Integer.parseInt(row[j - 1]);
            }
        }

        String[] order = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            x[i] = Integer.parseInt(order[i - 1]);
        }
    }

    public void process() {
        Arrays.fill(used, false);

        for (int k = 1; k <= n; k++) {
            used[x[k]] = true;
            updateMatrix(x[k]);
            ans.add(calculateMax());
        }
    }

    public void printResults(PrintWriter pw) {
        for (int result : ans) {
            pw.println(result);
        }
    }

    private void updateMatrix(int k) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
            }
        }
    }

    private int calculateMax() {
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (used[i] && used[j]) {
                    temp = Math.max(temp, matrix[i][j]);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        taskA task = new taskA();
        task.readInput(br);
        task.process();
        task.printResults(pw);

        pw.flush();
    }
}



