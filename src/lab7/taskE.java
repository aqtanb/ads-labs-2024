package lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class taskE {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer firstLine = new StringTokenizer(bufferedReader.readLine());
        int rowCount = Integer.parseInt(firstLine.nextToken());
        int columnCount = Integer.parseInt(firstLine.nextToken());

        List<int[]> rows = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            int[] row = new int[columnCount];
            StringTokenizer rowTokens = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < columnCount; j++) {
                row[j] = Integer.parseInt(rowTokens.nextToken());
            }
            rows.add(row);
        }

        rows.sort((row1, row2) -> {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < columnCount; i++) {
                sum1 += row1[i];
                sum2 += row2[i];
            }
            if (sum1 != sum2) return Integer.compare(sum2, sum1);
            for (int i = 0; i < columnCount; i++) {
                if (row1[i] != row2[i]) return Integer.compare(row1[i], row2[i]);
            }
            return 0;
        });

        StringBuilder result = new StringBuilder();
        for (int[] row : rows) {
            for (int value : row) {
                result.append(value).append(" ");
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}
