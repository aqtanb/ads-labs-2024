package lab10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class taskE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int q = Integer.parseInt(firstLine[1]);

        List<List<Integer>> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            List<Integer> tempRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tempRow.add(Integer.parseInt(row[j]));
            }
            a.add(tempRow);
        }

        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int f = Integer.parseInt(query[0]);
            int s = Integer.parseInt(query[1]);
            int t = Integer.parseInt(query[2]);

            if (a.get(f - 1).get(s - 1) == 1 && a.get(f - 1).get(t - 1) == 1 && a.get(s - 1).get(t - 1) == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

